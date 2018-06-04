package service;

import dao.PersonDAO;
import dao.VehicleDAO;
import domain.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sjoerd
 */
@Stateless
public class PersonService {

    @Inject
    PersonDAO personDAO;
    @Inject
    VehicleDAO vehicleDAO;

    @Inject AddressService addressService;

    private static final Logger LOGGER = Logger.getLogger(PersonService.class.getName());

    public PersonService() {
    }

    public Person getPerson(long id) throws PersistenceException {
        try {
            return personDAO.getPerson(id);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getPerson operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<Person> getAllPersons() throws PersistenceException {
        try {
            return personDAO.getAllPersons();
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAllPersons operation; {0}", pe.getMessage());
            return null;
        }
    }

    public Person insertPerson(Person person) {
        try {
            return personDAO.insertPerson(person);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertPerson operation; {0}", pe.getMessage());
            return null;
        }
    }

    public Person updatePerson(Person person) {
        try {
            return personDAO.updatePerson(person);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updatePerson operation; {0}", pe.getMessage());
            return null;
        }
    }

    public Person setPersonsAddress(int personId, Address address){
        Person managedPerson = this.getPerson(personId);
        if(managedPerson == null){
            // Modern Java compiler convert your + operations by StringBuilders append.
            throw new NullPointerException("ERROR while performing setPersonsAddress operation, can not find person with id " + personId );
        }

        Address managedAddress = addressService.findAddress(address);
        if(managedAddress == null){
            managedAddress = addressService.insertAddress(address);
        };

        managedPerson.setAddress(managedAddress);
        managedPerson = updatePerson(managedPerson);

        return managedPerson;

    }

    public Person getPersonByVehicle(Vehicle vehicle) {
        try {
            return personDAO.getPersonByVehicle(vehicle);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getPersonByVehicle operation; {0}", pe.getMessage());
            return null;
        }
    }

    public Person getPersonByLicensePlate(String licenseplate, boolean hashed) {
        try {
            Vehicle vehicle = vehicleDAO.getVehicle(licenseplate, hashed);
            return personDAO.getPersonByVehicle(vehicle);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getPersonByLicensePlate operation; {0}", pe.getMessage());
            return null;
        }
    }

}
