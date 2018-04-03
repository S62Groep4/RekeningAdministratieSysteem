package dao;

import domain.ITransLocation;
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

    @PersistenceContext(name = "ptt_test")
    EntityManager em;

    @Override
    public Journey getJourney(String id) throws PersistenceException {
        return (Journey) em.createNamedQuery("Journey.findById").setParameter("id", id).getSingleResult();
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
        Journey temp = em.find(Journey.class, journey.getId());
        for (ITransLocation tl : temp.getTransLocations()) {
            em.remove(tl);
        }

        em.remove(temp);
        return true;
    }

    @Override
    public boolean insertJourney(Journey journey) throws PersistenceException {
        em.persist(journey);
        return true;
    }

}
