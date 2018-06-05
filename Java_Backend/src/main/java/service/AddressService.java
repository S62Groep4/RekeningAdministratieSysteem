package service;

import dao.AddressDAO;
import domain.Address;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sjoerd
 */
@Stateless
public class AddressService {

    @Inject
    private AddressDAO addressDAO;

    private static final Logger LOGGER = Logger.getLogger(AddressService.class.getName());

    public AddressService() {
    }

    public Address getAddress(long id) throws PersistenceException {
        try {
            return addressDAO.getAddress(id);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAddress operation; {0}", pe.getMessage());
            return null;
        }
    }

    /**
     * This method searches for the address with the exact same values
     * @param address
     * @return A managed object of the address or a null value if the address does not exists
     */
    public Address findAddress(Address address) {
        try {
            return addressDAO.findAddress(address);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAddress operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<Address> getAllAddresses() throws PersistenceException {
        try {
            return addressDAO.getAllAddresses();
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAllAddresses operation; {0}", pe.getMessage());
            return null;
        }
    }




    public Address insertAddress(Address address) {
        try {
             addressDAO.insertAddress(address);
             return address;
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertAddress operation; {0}", pe.getMessage());
            return null;
        }
    }

    public Address updateAddress(Address address) {
        try {
            return addressDAO.updateAddress(address);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateAddress operation; {0}", pe.getMessage());
            return null;
        }
    }


}
