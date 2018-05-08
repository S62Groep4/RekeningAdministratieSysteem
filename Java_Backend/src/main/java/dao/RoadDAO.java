package dao;

import domain.Road;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
public interface RoadDAO {

    List<Road> getAllRoads() throws PersistenceException;

    Road getRoad(Long id) throws PersistenceException;
    
    Road getRoad(String name) throws PersistenceException;

    Road updateRoad(Road road) throws PersistenceException;

    void removeRoad(Long id) throws PersistenceException;

    Road insertRoad(Road road) throws PersistenceException;
}
