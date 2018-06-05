package dao;

import domain.Address;
import domain.Person;
import domain.Vehicle;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 *
 * @author Sjoerd
 */
public interface AddressDAO {

    Address getAddress(long id) throws PersistenceException;

    Address findAddress(Address address) throws PersistenceException;

    List<Address> getAllAddresses() throws PersistenceException;

    void insertAddress(Address address) throws PersistenceException;

    Address updateAddress(Address address) throws PersistenceException;

}
