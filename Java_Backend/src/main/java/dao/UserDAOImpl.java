package dao;

import domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Teun
 */
@Stateless
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> getUserByEmail(String email) {
        return em.createNamedQuery("User.getByEmail").setParameter("email", email).getResultList();
    }

    @Override
    public void insertUser(User user) {
        em.persist(user);
    }
}
