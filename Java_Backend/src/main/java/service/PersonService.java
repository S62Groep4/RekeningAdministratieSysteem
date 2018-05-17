package service;

import dao.PersonDAO;
import dao.VehicleDAO;
import domain.Journey;
import domain.Person;
import domain.SubInvoice;
import domain.Vehicle;

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
            LOGGER.log(Level.FINE, "ERROR while performing getAllPerson operation; {0}", pe.getMessage());
            return null;
        }
    }

    public Person createPerson(Person person){
        try {
            return personDAO.createPerson(person);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing createPerson operation; {0}", pe.getMessage());
            return null;
        }
    }

    public Person updatePerson(Person person){
        try {
            return personDAO.updatePerson(person);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing createPerson operation; {0}", pe.getMessage());
            return null;
        }
    }

    public Person getPersonByVehicle(Vehicle vehicle){
        try {
            return personDAO.getPersonByVehicle(vehicle);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing createPerson operation; {0}", pe.getMessage());
            return null;
        }
    }

    public Person getPersonByLicensePlate(String licenseplate, boolean hashed){
        try {
            Vehicle vehicle = vehicleDAO.getVehicle(licenseplate, hashed);
            return personDAO.getPersonByVehicle(vehicle);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing createPerson operation; {0}", pe.getMessage());
            return null;
        }
    }


}
