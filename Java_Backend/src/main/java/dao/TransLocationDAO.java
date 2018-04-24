package dao;

import domain.TransLocation;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
public interface TransLocationDAO {

    TransLocation getTransLocation(String serialNumber) throws PersistenceException;

    List<TransLocation> getAllTransLocations() throws PersistenceException;
    
    List<TransLocation> getAllTransLocationsByJourney(long id) throws PersistenceException;

    boolean updateTransLocation(TransLocation location) throws PersistenceException;

    boolean removeTransLocation(String serialNumber) throws PersistenceException;

    boolean insertTransLocation(TransLocation location) throws PersistenceException;

}
