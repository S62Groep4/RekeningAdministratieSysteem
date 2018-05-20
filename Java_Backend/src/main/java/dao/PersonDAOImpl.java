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
        return em.createQuery("Select p from Person p", Person.class)
                .getResultList();
    }

    @Override
    public Person createPerson(Person person) throws PersistenceException {
        em.persist(person);
        return person;
    }

    @Override
    public Person updatePerson(Person person) throws PersistenceException {
        em.merge(person);
        return person;
    }

    @Override
    public Person getPersonByVehicle(Vehicle vehicle) throws PersistenceException {
        return em.createNamedQuery("Person.GetPersonByCar", Person.class)
                .setParameter("vehicle", vehicle).getSingleResult();
    }
}