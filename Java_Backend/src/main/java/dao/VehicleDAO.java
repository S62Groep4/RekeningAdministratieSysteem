package dao;

import domain.Journey;
import domain.SubInvoice;
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
    
    List<SubInvoice> getVehicleInvoices(String hashedLicencePlate) throws PersistenceException;
    
    List<Journey> getVehicleJourneys(String hashedLicencePlate) throws PersistenceException;

    boolean updateVehicle(Vehicle vehicle) throws PersistenceException;

    boolean removeVehicle(String hashedLicenceplate) throws PersistenceException;

    boolean insertVehicle(Vehicle vehicle) throws PersistenceException;
}
