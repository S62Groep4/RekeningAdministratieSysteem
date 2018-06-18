package dao;

import domain.TransLocation;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
public interface TransLocationDAO {

    TransLocation getTransLocation(Long carTrackerId) throws PersistenceException;

    List<TransLocation> getAllTransLocations() throws PersistenceException;

    List<TransLocation> getAllTransLocationsByJourney(long id) throws PersistenceException;

    TransLocation updateTransLocation(TransLocation location) throws PersistenceException;

    void removeTransLocation(Long carTrackerId) throws PersistenceException;

    void remove(TransLocation transLocation);
    
    void truncate();

    TransLocation insertTransLocation(TransLocation location) throws PersistenceException;

}
