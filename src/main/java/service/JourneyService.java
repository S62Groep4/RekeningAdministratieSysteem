package service;

import dao.JourneyDAO;
import domain.Journey;
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
public class JourneyService {

    @Inject
    JourneyDAO journeyDao;

    private static final Logger LOGGER = Logger.getLogger(JourneyService.class.getName());

    public JourneyService() {
    }

    public Journey getJourney(String id) {
        try {
            return journeyDao.getJourney(id);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getJourney operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<Journey> getAllJourneys() {
        try {
            return journeyDao.getAllJourneys();
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAllJourneys operation; {0}", pe.getMessage());
            return null;
        }
    }

    public boolean updateJourney(Journey journey) throws PersistenceException {
        try {
            return journeyDao.updateJourney(journey);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateJourney operation; {0}", pe.getMessage());
            return false;
        }
    }

    public boolean removeJourney(Journey journey) throws PersistenceException {
        try {
            return journeyDao.removeJourney(journey);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeJourney operation; {0}", pe.getMessage());
            return false;
        }
    }

    public boolean insertJourney(Journey journey) throws PersistenceException {
        try {
            return journeyDao.insertJourney(journey);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertJourney operation; {0}", pe.getMessage());
            return false;
        }
    }
}
