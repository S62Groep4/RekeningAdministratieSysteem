package dao;

import domain.Person;
import domain.Vehicle;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 *
 * @author Sjoerd
 */
public interface PersonDAO {

    Person getPerson(long id) throws PersistenceException;

    List<Person> getAllPersons() throws PersistenceException;

    Person insertPerson(Person person) throws PersistenceException;

    Person updatePerson(Person person) throws PersistenceException;

    Person getPersonByVehicle(Vehicle vehicle) throws PersistenceException;

}
