package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Teun
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Journey.findAll", query = "SELECT j FROM Journey j")
    ,@NamedQuery(name = "Journey.findById", query = "SELECT j FROM Journey j WHERE j.id = :id")})
public class Journey implements IJourney, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private final List<ITransLocation> locations = new ArrayList<>();

    public Journey() {
    }

    // <editor-fold desc="Getters and Setters" defaultstate="collapsed">
    @Override
    public List<ITransLocation> getTransLocations() {
        return Collections.unmodifiableList(locations);
    }

    public long getId() {
        return id;
    }
    // </editor-fold>

    public boolean addTransLocation(ITransLocation loc) {
        if (loc != null) {
            locations.add(loc);
            return true;
        }
        return false;
    }

    public boolean addTransLocation(List<ITransLocation> loc) {
        if (loc != null) {
            locations.addAll(loc);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Journey)) {
            return false;
        }
        Journey otherUser = (Journey) obj;
        if (this.id == null || otherUser.id == null) {
            return false;
        }
        return this.id.equals(otherUser.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.locations);
        return hash;
    }
}
