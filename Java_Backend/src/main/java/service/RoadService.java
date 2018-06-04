package service;

import dao.RoadDAO;
import domain.Road;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
@Stateless
public class RoadService {

    @Inject
    RoadDAO roadDao;

    private static final Logger LOGGER = Logger.getLogger(RoadService.class.getName());

    public RoadService() {
    }

    public Road getRoad(Long id) throws PersistenceException {
        try {
            return roadDao.getRoad(id);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getRoad operation; {0}", pe.getMessage());
            return null;
        }
    }

    public Road getRoad(String name) throws PersistenceException {
        try {
            return roadDao.getRoad(name);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getRoad operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<Road> searchRoad(String name) throws PersistenceException {
        try {
            return roadDao.searchRoad(name);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getRoad operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<Road> getAllRoads() throws PersistenceException {
        try {
            return roadDao.getAllRoads();
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAllRoads operation; {0}", pe.getMessage());
            return null;
        }
    }

    public Road updateRoad(Road road) throws PersistenceException {
        try {
            return roadDao.updateRoad(road);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateRoad operation; {0}", pe.getMessage());
            return null;
        }
    }

    public void removeRoad(Long id) throws PersistenceException {
        try {
            roadDao.removeRoad(id);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeRoad operation; {0}", pe.getMessage());
        }
    }

    public Road insertRoad(Road road) throws PersistenceException {
        try {
            return roadDao.insertRoad(road);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertRoad operation; {0}", pe.getMessage());
            return null;
        }
    }
}
