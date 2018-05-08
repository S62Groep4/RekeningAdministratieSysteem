package dao;

import domain.Journey;
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
public class JourneyDAOImpl implements JourneyDAO {

    @PersistenceContext(name = "ptt_test")
    EntityManager em;

    @Override
    public List<Journey> getAllJourneys() throws PersistenceException {
        return em.createNamedQuery("Journey.findAll").getResultList();
    }

    @Override
    public Journey getJourney(Long id) throws PersistenceException {
        return (Journey) em.createNamedQuery("Journey.findById").setParameter("journeyId", id).getSingleResult();
    }

    @Override
    public Journey updateJourney(Journey journey) throws PersistenceException {
        return em.merge(journey);
    }

    @Override
    public void removeJourney(Long id) throws PersistenceException {
        Journey temp = em.find(Journey.class, id);

        for (TransLocation t : temp.getTransLocations()) {
            em.remove(t);
        }

        em.remove(temp);
    }

    @Override
    public Journey insertJourney(Journey journey) throws PersistenceException {
        em.persist(journey);
        return journey;
    }
}
