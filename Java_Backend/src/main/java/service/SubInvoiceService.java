package service;

import GoogleApi.SnappedPoint;
import dao.RoadDAO;
import dao.SubInvoiceDAO;
import dao.VehicleDAO;
import domain.Journey;
import domain.Road;
import domain.SubInvoice;
import domain.TransLocation;
import domain.Vehicle;
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

/**
 *
 * @author Teun
 */
@Stateless
public class SubInvoiceService {

    @Inject
    SubInvoiceDAO subinvoiceDao;

    @Inject
    VehicleDAO vehicleDao;

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
        try {
            List<Vehicle> vehicles = vehicleDao.getAllVehicles();
            for (Vehicle v : vehicles) {
//                clear invoices for this vehicle before (re)calculating to avoid duplicates
                v.clearInvoices();

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
                            temp = roadDao.getRoad(roadNameEntry.getValue());
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
                        SubInvoice invoice = new SubInvoice(null, "49", roundToPrice(price), entry.getKey());
                        invoice.setVehicle(v);
                        invoice.addJourneys(entry.getValue());
                        v.addInvoice(invoice);
                    }
                }
                vehicleDao.updateVehicle(v);
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

    public SubInvoice insertRemoteSubInvoice(SubInvoice invoice, Long carTrackerId) throws PersistenceException {
        try {
            Vehicle v = vehicleDao.getVehicle(carTrackerId);
            if (v != null) {
                v.addInvoice(invoice);
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
}
