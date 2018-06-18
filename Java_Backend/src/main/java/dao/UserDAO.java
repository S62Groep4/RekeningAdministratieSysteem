package dao;

import domain.User;
import java.util.List;

/**
 *
 * @author Teun
 */
public interface UserDAO {

    List<User> getUserByEmail(String email);

    void insertUser(User user);
}