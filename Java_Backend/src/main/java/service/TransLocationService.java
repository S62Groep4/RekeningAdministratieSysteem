package service;

import dao.TransLocationDAO;
import domain.TransLocation;
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
public class TransLocationService {

    @Inject
    TransLocationDAO translocationDao;

    private static final Logger LOGGER = Logger.getLogger(TransLocationService.class.getName());

    public TransLocationService() {
    }
    
    public List<TransLocation> getAllTransLocationsByJourney(long id){
        try {
            return translocationDao.getAllTransLocationsByJourney(id);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getTransLocation operation; {0}", pe.getMessage());
            return null;
        }
    }

    public TransLocation getTransLocation(String serialNumber) throws PersistenceException {
        try {
            return translocationDao.getTransLocation(serialNumber);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getTransLocation operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<TransLocation> getAllTransLocations() throws PersistenceException {
        try {
            return translocationDao.getAllTransLocations();
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAllTransLocations operation; {0}", pe.getMessage());
            return null;
        }
    }

    public boolean updateTransLocation(TransLocation location) throws PersistenceException {
        try {
            return translocationDao.updateTransLocation(location);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateTransLocation operation; {0}", pe.getMessage());
            return false;
        }
    }

    public boolean removeTransLocation(String serialNumber) throws PersistenceException {
        try {
            return translocationDao.removeTransLocation(serialNumber);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeTransLocation operation; {0}", pe.getMessage());
            return false;
        }
    }

    public boolean insertTransLocation(TransLocation location) throws PersistenceException {
        try {
            return translocationDao.insertTransLocation(location);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertTransLocation operation; {0}", pe.getMessage());
            return false;
        }
    }
}
