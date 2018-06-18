package dao;

import domain.Journey;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
public interface JourneyDAO {

    List<Journey> getAllJourneys() throws PersistenceException;
    
    Journey getJourney(Long id) throws PersistenceException;

    Journey updateJourney(Journey journey) throws PersistenceException;

    void removeJourney(Long id) throws PersistenceException;

    Journey insertJourney(Journey journey) throws PersistenceException;
    
    void flush();
    
    void truncate();
}
