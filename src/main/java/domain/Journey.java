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

/**
 *
 * @author Teun
 */
@Entity
public class Journey implements IJourney, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private final List<ITransLocation> locations = new ArrayList<>();

    public Journey() {
    }

    @Override
    public List<ITransLocation> getTransLocations() {
        return Collections.unmodifiableList(locations);
    }

    public long getId() {
        return id;
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
        int hash = 2;
        hash = 12 * hash + Objects.hashCode(this.id);
        hash = 12 * hash + Objects.hashCode(this.locations);
        return hash;
    }

}
