package service;

import GoogleApi.PlaceResponse;
import GoogleApi.SnappedPoint;
import dao.SubInvoiceDAO;
import dao.VehicleDAO;
import domain.Journey;
import domain.SubInvoice;
import domain.TransLocation;
import domain.Vehicle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
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
    VehicleDAO vehicleDao;

    private static final Logger LOGGER = Logger.getLogger(SubInvoiceService.class.getName());

    public SubInvoiceService() {
    }

    public void generateSubInvoices() {
        try {
            List<Vehicle> vehicles = vehicleDao.getAllVehicles();
            for (Vehicle v : vehicles) {

                for (SubInvoice i : v.getSubInvoices()) {
                    i.setVehicle(null);
                }
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
                    SubInvoice invoice = new SubInvoice(null, "49", 0, entry.getKey());
                    double price = 0;

                    /*
//                zoek de wegen via Google api
                    List<TransLocation> locationsThisMonth = new ArrayList();
                    for (Journey j : entry.getValue()) {
                        locationsThisMonth.addAll(j.getTransLocations());
                    }
                    List<SnappedPoint> snappedPoints = GoogleApi.NearestRoads.CoordinatesToPlaceIds(DomainToDto.TRANSLOCATIONSTODTOS(locationsThisMonth));

                    Set<String> uniquePlaceIds = new TreeSet();

//                 voeg de placeId's toe aan een set zodat er geen dubbele entries zijn
                    for (SnappedPoint sp : snappedPoints) {
                        uniquePlaceIds.add(sp.getPlaceId());
                    }

//                 zoek de wegnamen (short_name)
                    Map<String, String> roadNames = new HashMap();
                    for (String uniquePlaceId : uniquePlaceIds) {
                        roadNames.put(uniquePlaceId, GoogleApi.RoadNames.PlaceIdToRoadName(uniquePlaceId).getShort_name());
                    }

                    //TO DO 
                    //koppel prijs aan de wegen en set de prijs van de invoice
                     */
                    invoice.setVehicle(v);
                    invoice.setPrice(price);
                    v.addInvoice(invoice);
                }

                vehicleDao.updateVehicle(v);
            }
        } catch (PersistenceException /*| IOException*/ pe) {
            LOGGER.log(Level.FINE, "ERROR while performing generateSubInvoices operation; {0}", pe.getMessage());
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
}
