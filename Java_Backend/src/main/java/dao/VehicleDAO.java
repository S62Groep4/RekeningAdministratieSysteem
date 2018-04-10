package dao;

import domain.Vehicle;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
public interface VehicleDAO {

    Vehicle getVehicle(String hashedLicenceplate) throws PersistenceException;

    List<Vehicle> getAllVehicles() throws PersistenceException;

    boolean updateVehicle(Vehicle vehicle) throws PersistenceException;

    boolean removeVehicle(String hashedLicenceplate) throws PersistenceException;

    boolean insertVehicle(Vehicle vehicle) throws PersistenceException;
}
