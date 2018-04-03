package dao;

import domain.Journey;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
public interface JourneyDAO {

    Journey getJourney(String id) throws PersistenceException;

    List<Journey> getAllJourneys() throws PersistenceException;

    boolean updateJourney(Journey journey) throws PersistenceException;

    boolean removeJourney(String id) throws PersistenceException;

    boolean insertJourney(Journey journey) throws PersistenceException;

}
