package dao;

import domain.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
@Stateless
public class VehicleDAOImpl implements VehicleDAO {

    @PersistenceContext(name = "ptt_test")
    EntityManager em;

    @Override
    public Vehicle getVehicle(String hashedLicenceplate) throws PersistenceException {
        return (Vehicle) em.createNamedQuery("Vehicle.findByLicenceplate").setParameter("licencePlate", hashedLicenceplate).getSingleResult();
    }

    @Override
    public List<Vehicle> getAllVehicles() throws PersistenceException {
        return em.createNamedQuery("Vehicle.findAll").getResultList();
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle) throws PersistenceException {
        em.merge(vehicle);
        return true;
    }

    @Override
    public boolean removeVehicle(Vehicle vehicle) throws PersistenceException {
        em.remove(vehicle);
        return true;
    }

    @Override
    public boolean insertVehicle(Vehicle vehicle) throws PersistenceException {
        em.persist(vehicle);
        return true;
    }

}