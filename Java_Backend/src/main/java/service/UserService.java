package service;

import dao.UserDAO;
import domain.User;
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
public class UserService {

    @Inject
    UserDAO userDAO;

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    public UserService() {
    }

    public void insertUser(User user) {
        try {
            userDAO.insertUser(user);
        } catch (PersistenceException ex) {
            LOGGER.log(Level.FINE, "ERROR while performing insertUser method; {0}", ex.getMessage());
        }
    }

    public List<User> getUser(String email) {
        try {
            List<User> user = userDAO.getUserByEmail(email);
            return user;
        } catch (PersistenceException ex) {
            LOGGER.log(Level.FINE, "ERROR while performing getUser method; {0}", ex.getMessage());
            return null;
        }
    }
}
