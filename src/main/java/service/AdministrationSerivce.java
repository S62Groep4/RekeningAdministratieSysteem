package service;

import dao.JourneyDAO;
import dao.SubInvoiceDAO;
import dao.TransLocationDAO;
import dao.VehicleDAO;
import domain.Journey;
import domain.SubInvoice;
import domain.TransLocation;
import domain.Vehicle;
import java.util.List;
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
public class AdministrationSerivce {

    @Inject
    VehicleDAO vehicleDao;

    @Inject
    TransLocationDAO translocationDao;

    @Inject
    SubInvoiceDAO subinvoiceDao;

    @Inject
    JourneyDAO journeyDao;

    private static final Logger LOGGER = Logger.getLogger(AdministrationSerivce.class.getName());

    public AdministrationSerivce() {
    }

    public Journey getJourney(String id) {
        try {
            return journeyDao.getJourney(id);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getJourney operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<Journey> getAllJourneys() {
        try {
            return journeyDao.getAllJourneys();
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAllJourneys operation; {0}", pe.getMessage());
            return null;
        }
    }

    public boolean updateJourney(Journey journey) throws PersistenceException {
        try {
            return journeyDao.updateJourney(journey);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateJourney operation; {0}", pe.getMessage());
            return false;
        }
    }

    public boolean removeJourney(Journey journey) throws PersistenceException {
        try {
            return journeyDao.removeJourney(journey);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeJourney operation; {0}", pe.getMessage());
            return false;
        }
    }

    public boolean insertJourney(Journey journey) throws PersistenceException {
        try {
            return journeyDao.insertJourney(journey);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertJourney operation; {0}", pe.getMessage());
            return false;
        }
    }

    public SubInvoice getSubInvoice(String invoiceNumber) throws PersistenceException {
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

    public boolean updateSubInvoice(SubInvoice invoice) throws PersistenceException {
        try {
            return subinvoiceDao.updateSubInvoice(invoice);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateSubInvoice operation; {0}", pe.getMessage());
            return false;
        }
    }

    public boolean removeSubInvoice(SubInvoice invoice) throws PersistenceException {
        try {
            return subinvoiceDao.removeSubInvoice(invoice);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeSubInvoice operation; {0}", pe.getMessage());
            return false;
        }
    }

    public boolean insertSubInvoice(SubInvoice invoice) throws PersistenceException {
        try {
            return subinvoiceDao.insertSubInvoice(invoice);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertSubInvoice operation; {0}", pe.getMessage());
            return false;
        }
    }

    public TransLocation getTransLocation(String serialNumber) throws PersistenceException {
        try {
            return translocationDao.getTransLocation(serialNumber);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getTransLocation operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<TransLocation> getAllTransLocations() throws PersistenceException {
        try {
            return translocationDao.getAllTransLocations();
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAllTransLocations operation; {0}", pe.getMessage());
            return null;
        }
    }

    public boolean updateTransLocation(TransLocation location) throws PersistenceException {
        try {
            return translocationDao.updateTransLocation(location);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateTransLocation operation; {0}", pe.getMessage());
            return false;
        }
    }

    public boolean removeTransLocation(TransLocation location) throws PersistenceException {
        try {
            return translocationDao.removeTransLocation(location);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeTransLocation operation; {0}", pe.getMessage());
            return false;
        }
    }

    public boolean insertTransLocation(TransLocation location) throws PersistenceException {
        try {
            return translocationDao.insertTransLocation(location);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertTransLocation operation; {0}", pe.getMessage());
            return false;
        }
    }

    public Vehicle getVehicle(String hashedLicenceplate) throws PersistenceException {
        try {
            return vehicleDao.getVehicle(hashedLicenceplate);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getVehicle operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<Vehicle> getAllVehicles() throws PersistenceException {
        try {
            return vehicleDao.getAllVehicles();
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAllVehicles operation; {0}", pe.getMessage());
            return null;
        }
    }

    public boolean updateVehicle(Vehicle vehicle) throws PersistenceException {
        try {
            return vehicleDao.updateVehicle(vehicle);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateVehicle operation; {0}", pe.getMessage());
            return false;
        }
    }

    public boolean removeVehicle(Vehicle vehicle) throws PersistenceException {
        try {
            return vehicleDao.removeVehicle(vehicle);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeVehicle operation; {0}", pe.getMessage());
            return false;
        }
    }

    public boolean insertVehicle(Vehicle vehicle) throws PersistenceException {
        try {
            return vehicleDao.insertVehicle(vehicle);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertVehicle operation; {0}", pe.getMessage());
            return false;
        }
    }
}
