package service;

import dao.VehicleDAO;
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
