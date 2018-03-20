package dao;

import domain.Journey;
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
public class JourneyDAOImpl implements JourneyDAO {

    @PersistenceContext(name = "groep4.ptt_PU")
    EntityManager em;

    @Override
    public List<Journey> getJourney(String id) throws PersistenceException {
        return em.createNamedQuery("Journey.findById").setParameter("id", id).getResultList();
    }

    @Override
    public List<Journey> getAllJourneys() throws PersistenceException {
        return em.createNamedQuery("Journey.findAll").getResultList();
    }

    @Override
    public boolean updateJourney(Journey journey) throws PersistenceException {
        em.merge(journey);
        return true;
    }

    @Override
    public boolean removeJourney(Journey journey) throws PersistenceException {
        em.remove(journey);
        return true;
    }

    @Override
    public boolean insertJourney(Journey journey) throws PersistenceException {
        em.persist(journey);
        return true;
    }

}
