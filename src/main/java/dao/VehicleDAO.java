package dao;

import domain.IVehicle;
import java.util.List;

/**
 *
 * @author Teun
 */
public interface VehicleDAO {

    List<IVehicle> getVehicle(String hashedLicenceplate);

    List<IVehicle> getAllVehicles();

    boolean updateVehicle(IVehicle vehicle);

    boolean removeVehicle(IVehicle vehicle);

    boolean insertVehicle(IVehicle vehicle);
}
