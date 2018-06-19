package dao;

import domain.Journey;
import domain.Person;
import domain.SubInvoice;
import domain.Vehicle;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

/**
 *
 * @author Teun
 */
@Stateless
public class PersonDAOImpl implements PersonDAO {

    @PersistenceContext(name = "ptt_test")
    EntityManager em;

    @Override
    public Person getPerson(long id) throws PersistenceException {
        return em.find(Person.class, id);
    }

    @Override
    public List<Person> getAllPersons() throws PersistenceException {
        return em.createNamedQuery("Person.findAll").getResultList();
    }

    @Override
    public Person insertPerson(Person person) throws PersistenceException {
        em.persist(person);
        return person;
    }

    @Override
    public Person updatePerson(Person person) throws PersistenceException {
        return em.merge(person);
    }

    @Override
    public Person getPersonByVehicle(Vehicle vehicle) throws PersistenceException {
        return em.createNamedQuery("Person.findPersonByCar", Person.class)
                .setParameter("vehicle", vehicle).getSingleResult();
    }

    @Override
    public Person getPerson(String userAccountEmail) throws PersistenceException {
        return em.createNamedQuery("Person.findByUserEmail", Person.class)
                .setParameter("email", userAccountEmail).getSingleResult();
    }

    @Override
    public Person getPersonAndFetchVehiclesEagerly(String userAccountEmail) throws PersistenceException {
        return em.createNamedQuery("Person.findByUserEmailWithVehicles", Person.class)
                .setParameter("email", userAccountEmail).getSingleResult();
    }
}
