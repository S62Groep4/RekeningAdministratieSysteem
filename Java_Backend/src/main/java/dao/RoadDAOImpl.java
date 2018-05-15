package dao;

import domain.Road;
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
public class RoadDAOImpl implements RoadDAO {

    @PersistenceContext(name = "ptt_test")
    EntityManager em;

    @Override
    public List<Road> getAllRoads() throws PersistenceException {
        return em.createNamedQuery("Road.findAll").getResultList();
    }

    @Override
    public Road getRoad(Long id) throws PersistenceException {
        Road road = (Road) em.createNamedQuery("Road.findById").setParameter("roadId", id).getSingleResult();
        if (road != null) {
            return road;
        }
        return new Road();
    }

    @Override
    public Road getRoad(String name) throws PersistenceException {
        Road road = (Road) em.createNamedQuery("Road.findByname").setParameter("roadName", name).getSingleResult();
        if (road != null) {
            return road;
        }
        return new Road();
    }

    @Override
    public Road updateRoad(Road road) throws PersistenceException {
        return em.merge(road);
    }

    @Override
    public void removeRoad(Long id) throws PersistenceException {
        Road road = em.find(Road.class, id);
        em.remove(road);
    }

    @Override
    public Road insertRoad(Road road) throws PersistenceException {
        em.persist(road);
        em.flush();
        return road;
    }
}
