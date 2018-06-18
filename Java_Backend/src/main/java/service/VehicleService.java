package service;

import dao.VehicleDAO;
import domain.Journey;
import domain.SubInvoice;
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
public class VehicleService {

    @Inject
    VehicleDAO vehicleDao;

    private static final Logger LOGGER = Logger.getLogger(VehicleService.class.getName());

    public VehicleService() {
    }

    public Vehicle getVehicle(String hashedLicenceplate, boolean hashed) throws PersistenceException {
        try {
            return vehicleDao.getVehicle(hashedLicenceplate, hashed);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getVehicle operation; {0}", pe.getMessage());
            return null;
        }
    }

    public Vehicle getVehicle(String carTrackerId) throws PersistenceException {
        try {
            return vehicleDao.getVehicle(carTrackerId);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getVehicle operation; {0}", pe.getMessage());
            return null;
        }
    }
    
    public List<Vehicle> getVehiclesOwnedBy(Long personId) throws PersistenceException {
        try {
            return vehicleDao.getVehiclesOwnedBy(personId);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getVehiclesOwnedBy operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<SubInvoice> getVehicleInvoices(String hashedLicenceplate) throws PersistenceException {
        try {
            return vehicleDao.getVehicleInvoices(hashedLicenceplate);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getVehicleInvoices operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<Journey> getVehicleJourneys(String hashedLicenceplate) throws PersistenceException {
        try {
            return vehicleDao.getVehicleJourneys(hashedLicenceplate);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getVehicleJourneys operation; {0}", pe.getMessage());
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

    public Vehicle updateVehicle(Vehicle vehicle) throws PersistenceException {
        try {
            return vehicleDao.updateVehicle(vehicle);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateVehicle operation; {0}", pe.getMessage());
            return null;
        }
    }

    public void removeVehicle(String hashedLicenceplate) throws PersistenceException {
        try {
            vehicleDao.removeVehicle(hashedLicenceplate);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeVehicle operation; {0}", pe.getMessage());
        }
    }

    public Vehicle insertVehicle(Vehicle vehicle) throws PersistenceException {
        try {
            return vehicleDao.insertVehicle(vehicle);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertVehicle operation; {0}", pe.getMessage());
            return null;
        }
    }
}
