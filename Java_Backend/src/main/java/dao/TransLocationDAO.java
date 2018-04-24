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

    TransLocation updateTransLocation(TransLocation location) throws PersistenceException;

    void removeTransLocation(String serialNumber) throws PersistenceException;

    TransLocation insertTransLocation(TransLocation location) throws PersistenceException;

}
