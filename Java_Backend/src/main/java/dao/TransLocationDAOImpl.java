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
        TransLocation location = (TransLocation) em.createNamedQuery("TransLocation.findBySerialNumber").setParameter("serialNumber", serialNumber).getSingleResult();
        if (location != null) {
            return location;
        }
        return new TransLocation();
    }

    @Override
    public List<TransLocation> getAllTransLocations() throws PersistenceException {
        return em.createNamedQuery("TransLocation.findAll").getResultList();
    }

    @Override
    public List<TransLocation> getAllTransLocationsByJourney(long id) throws PersistenceException {
        return em.createNamedQuery("TransLocation.findByJourneyId").setParameter("journeyId", id).getResultList();
    }

    @Override
    public TransLocation updateTransLocation(TransLocation location) throws PersistenceException {
        return em.merge(location);
    }

    @Override
    public void removeTransLocation(String serialNumber) throws PersistenceException {
        em.remove(em.find(TransLocation.class, serialNumber));
    }

    @Override
    public TransLocation insertTransLocation(TransLocation location) throws PersistenceException {
        em.persist(location);
        return location;
    }
}
