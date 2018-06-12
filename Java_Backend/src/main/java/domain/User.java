package domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Teun
 */

@Entity
@NamedQueries({
@NamedQuery(name = "User.getByEmail", query = "SELECT u FROM User u WHERE u.email LIKE :email")})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToOne
    private Person person;

    private static final int workload = 12;
    private static final String salt = BCrypt.gensalt(workload);

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    protected User() {

    }

    public User(String email, String password) {
        this.email = email;
        this.password = BCrypt.hashpw(password, salt);
    }
}