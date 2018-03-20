package dao;

import domain.TransLocation;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
public interface TransLocationDAO {

    List<TransLocation> getTransLocation(String serialNumber) throws PersistenceException;

    List<TransLocation> getAllTransLocations() throws PersistenceException;

    boolean updateTransLocation(TransLocation location) throws PersistenceException;

    boolean removeTransLocation(TransLocation location) throws PersistenceException;

    boolean insertTransLocation(TransLocation location) throws PersistenceException;

}
