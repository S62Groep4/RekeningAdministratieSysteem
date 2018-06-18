package service;

import GoogleApi.SnappedPoint;
import dao.JourneyDAO;
import dao.RoadDAO;
import dao.SubInvoiceDAO;
import dao.TransLocationDAO;
import dao.VehicleDAO;
import domain.Journey;
import domain.Road;
import domain.SubInvoice;
import domain.TransLocation;
import domain.Vehicle;
import dto.SubInvoiceDTO;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import jms.InvoiceProducer;
import util.DomainToDto;

/**
 *
 * @author Teun
 */
@Stateless
public class SubInvoiceService {

    @Inject
    SubInvoiceDAO subinvoiceDao;

    @Inject
    TransLocationDAO transLocationDAO;

    @Inject
    JourneyDAO journeyDAO;

    @Inject
    VehicleDAO vehicleDao;

    @Inject
    JourneyService journeyService;

    @Inject
    InvoiceProducer invoiceProducer;

    @Inject
    RoadDAO roadDao;

    private static final Logger LOGGER = Logger.getLogger(SubInvoiceService.class.getName());
    private final double BASETAX = 0.05;

    public SubInvoiceService() {
    }

    private static double roundToPrice(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void generateSubInvoices() {
        for (Vehicle v : vehicleDao.getAllVehicles()) {
            v.removeJourneys();
//            for (Journey j : v.getJourneys()) {
//                v.removeJourney(j);
//                for (TransLocation t : j.getTransLocations()) {
//                    transLocationDAO.remove(t);
//                }
//            }
            v.removeInvoices();
        }

        subinvoiceDao.truncate();
        transLocationDAO.truncate();
        journeyDAO.truncate();

        vehicleDao.flush();

        try {
            journeyService.updateJourneysFromRegistration();
        } catch (IOException ex) {
            System.out.println("Update journeys error: " + ex.getMessage());
        }

        try {
            List<Vehicle> vehicles = vehicleDao.getAllVehicles();
            for (Vehicle v : vehicles) {
//                clear invoices for this vehicle before (re)calculating to avoid duplicates
                //v.clearInvoices();
                //vehicleDao.flush();

                Map<String, List<Journey>> journeysPerMonth = new HashMap();
                List<TransLocation> locations;

//                lijst splitten per maand
//                hashmap is <"yyyy-MM", lijst van journeys in deze maand>
//                in welke maand een journey valt hangt af van de datetime string van 
//                de eerste translocation binnen deze journey
                for (Journey j : v.getJourneys()) {
                    locations = j.getTransLocations();
                    if (!journeysPerMonth.containsKey(locations.get(0).getDateTime().substring(0, 7))) {
                        journeysPerMonth.put(locations.get(0).getDateTime().substring(0, 7), new ArrayList());
                    }
                    journeysPerMonth.get(locations.get(0).getDateTime().substring(0, 7)).add(j);
                }

                for (Map.Entry<String, List<Journey>> entry : journeysPerMonth.entrySet()) {
                    double price = 0;

//                zoek de wegen via Google api
                    List<TransLocation> locationsThisMonth = new ArrayList();
                    for (Journey j : entry.getValue()) {
                        locationsThisMonth.addAll(j.getTransLocations());
                    }

                    Map<TransLocation, SnappedPoint> snappedPoints = new HashMap();
                    try {
                        snappedPoints = GoogleApi.NearestRoads.CoordinatesToPlaceIds(locationsThisMonth);
                    } catch (IOException ex) {
                        //handle coordinate could not be mapped to placeID
                        LOGGER.log(Level.SEVERE, null, ex);
                    }

//                 zoek de wegnamen (short_name)
                    Map<String, String> roadNames = new HashMap();
                    for (SnappedPoint sp : snappedPoints.values()) {
                        try {
                            roadNames.put(sp.getPlaceId(), GoogleApi.RoadNames.PlaceIdToRoadName(sp.getPlaceId()).getShort_name());
                        } catch (Exception ex) {
                            //handle placeID could not be mapped to road name
                            LOGGER.log(Level.SEVERE, null, ex);
                        }
                    }

//                 map roadTaxRates container <uniquePlaceId, taxrate>
                    Map<String, Double> roadTaxRates = new HashMap();
                    for (Entry<String, String> roadNameEntry : roadNames.entrySet()) {
                        Road temp;
                        try {
                            List<Road> roads = roadDao.getRoad(roadNameEntry.getValue());
                            if (roads.isEmpty()) {
                                temp = new Road(roadNameEntry.getValue(), roadNameEntry.getValue(), BASETAX);
                            } else {
                                temp = roads.get(0);
                            }
                            //temp = roadDao.getRoad(roadNameEntry.getValue());
                        } catch (PersistenceException pe) {
//                            if road not found
                            continue;
                        }
                        roadTaxRates.put(roadNameEntry.getKey(), temp.getRate());
                    }

                    //TO DO 
                    //koppel prijs aan de wegen en set de prijs van de invoice
                    for (TransLocation l : locationsThisMonth) {
                        try {
                            //debug wat er precies gebeurt met duplicates
                            //wel/niet toegevoegd aan prijs
                            price += roadTaxRates.get(snappedPoints.get(l).getPlaceId());
                        } catch (NullPointerException pne) {
                            //als weg niet gevonden is dan houd basisprijs aan
                            price += BASETAX;
                        }
                    }

                    if (price != 0) {
                        SubInvoice invoice = new SubInvoice(null, "DE", roundToPrice(price), entry.getKey());
                        invoice.setVehicle(v);
                        invoice.addJourneys(entry.getValue());
                        v.addInvoice(invoice);
                        subinvoiceDao.insertSubInvoice(invoice);
                    } else {
                        System.out.println("Price is 0!");
                    }
                }
                subinvoiceDao.flush();

                vehicleDao.updateVehicle(v);
                //vehicleDao.insertVehicle(v);
            }
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing generateSubInvoices operation; {0}", pe.getMessage());
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "ERROR while performing generateSubInvoices operation; {0}", ex.getMessage());
        }
    }

    public SubInvoice getSubInvoice(Long invoiceNumber) throws PersistenceException {
        try {
            return subinvoiceDao.getSubInvoice(invoiceNumber);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getSubInvoice operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<SubInvoice> getAllSubInvoices() throws PersistenceException {
        try {
            return subinvoiceDao.getAllSubInvoices();
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAllSubInvoices operation; {0}", pe.getMessage());
            return null;
        }
    }

    public SubInvoice updateSubInvoice(SubInvoice invoice) throws PersistenceException {
        try {
            return subinvoiceDao.updateSubInvoice(invoice);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateSubInvoice operation; {0}", pe.getMessage());
            return null;
        }
    }

    public void removeSubInvoice(Long invoiceNumber) throws PersistenceException {
        try {
            subinvoiceDao.removeSubInvoice(invoiceNumber);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeSubInvoice operation; {0}", pe.getMessage());
        }
    }

    public SubInvoice insertSubInvoice(SubInvoice invoice) throws PersistenceException {
        try {
            return subinvoiceDao.insertSubInvoice(invoice);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertSubInvoice operation; {0}", pe.getMessage());
            return null;
        }
    }

    public SubInvoice insertRemoteSubInvoice(SubInvoice/*DTO*/ invoice) throws PersistenceException {
        try {
//            SubInvoice newInvoice = new SubInvoice(null, invoice.getCountry(), invoice.getPrice(), invoice.getInvoiceDate(), null);
            return subinvoiceDao.insertSubInvoice(invoice);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertRemoteSubInvoice operation; {0}", pe.getMessage());
            return null;
        }
    }

    public SubInvoice insertRemoteSubInvoice(SubInvoice invoice, String carTrackerId) throws PersistenceException {
        try {
            List<Vehicle> foundVehicles = vehicleDao.getVehicle(carTrackerId);
            if (!foundVehicles.isEmpty()) {
                foundVehicles.get(0).addInvoice(invoice);
                return subinvoiceDao.insertSubInvoice(invoice);
            }
            return null;
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertRemoteSubInvoice operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<Journey> getSubInvoiceJourneys(Long invoiceNumber) {
        SubInvoice subInvoice = this.getSubInvoice(invoiceNumber);
        return subInvoice.getJourneys();
    }

    public void sendToEu(String countryCode) {
        List<SubInvoice> subInvoices = subinvoiceDao.getAllSubInvoices();
        switch (countryCode) {
            case "FI": {
                List<SubInvoice> finlandInvoices = new ArrayList<>();
                for (SubInvoice si : subInvoices) {
                    if(!si.getJourneys().isEmpty() && !si.getJourneys().get(0).getTransLocations().isEmpty()) {
                        if(si.getJourneys().get(0).getTransLocations().get(0).getCountryCode().equals("FI")) {
                            finlandInvoices.add(si);
                        }
                    }
                }
                List<SubInvoiceDTO> subInvoiceDTOs = DomainToDto.SUBINVOICESTODTOS(finlandInvoices);
                for(SubInvoiceDTO subInvoiceDTO : subInvoiceDTOs) {
                    System.out.println("service.SubInvoiceService.sendToEu()");
                    invoiceProducer.send(subInvoiceDTO);
                }
                break;
            }
        }
    }
}
