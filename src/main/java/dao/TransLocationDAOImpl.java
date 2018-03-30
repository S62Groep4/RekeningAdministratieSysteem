package dao;

import domain.TransLocation;
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
public class TransLocationDAOImpl implements TransLocationDAO {

    @PersistenceContext(name = "ptt_test")
    EntityManager em;

    @Override
    public TransLocation getTransLocation(String serialNumber) throws PersistenceException {
        return (TransLocation) em.createNamedQuery("TransLocation.findBySerialNumber").setParameter("serialNumber", serialNumber).getSingleResult();
    }

    @Override
    public List<TransLocation> getAllTransLocations() throws PersistenceException {
        return em.createNamedQuery("TransLocation.findAll").getResultList();
    }

    @Override
    public boolean updateTransLocation(TransLocation location) throws PersistenceException {
        em.merge(location);
        return true;
    }

    @Override
    public boolean removeTransLocation(TransLocation location) throws PersistenceException {
        em.remove(location);
        return true;
    }

    @Override
    public boolean insertTransLocation(TransLocation location) throws PersistenceException {
        em.persist(location);
        return true;
    }
}