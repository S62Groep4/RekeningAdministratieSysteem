package dao;

import domain.Address;
import domain.Journey;
import domain.TransLocation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

/**
 *
 * @author Sjoerd
 */
@Stateless
public class AddressDAOImpl implements AddressDAO {

    @PersistenceContext(name = "ptt_test")
    EntityManager em;

    @Override
    public Address getAddress(long id) throws PersistenceException {
        return em.find(Address.class, id);
    }

    @Override
    public Address findAddress(Address address) throws PersistenceException {
        return (Address) em.createNamedQuery("Address.findAddress")
                            .setParameter("streetName", address.getStreetName())
                            .setParameter("streetNumber", address.getStreetNumber())
                            .setParameter("zipCode", address.getZipCode())
                            .setParameter("city", address.getCity())
                            .setParameter("country", address.getCountry())
                            .getSingleResult();
    }

    @Override
    public List<Address> getAllAddresses() throws PersistenceException {
        return em.createNamedQuery("Address.getAll").getResultList();
    }

    @Override
    public void insertAddress(Address address) throws PersistenceException {
        em.persist(address);
    }

    @Override
    public Address updateAddress(Address address) throws PersistenceException {
        return em.merge(address);
    }
}
