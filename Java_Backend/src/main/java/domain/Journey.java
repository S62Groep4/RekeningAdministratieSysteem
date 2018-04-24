package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Teun
 */
@Entity
public class Journey implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToMany(mappedBy = "journey", cascade = ALL)
    private final List<TransLocation> locations = new ArrayList<>();
    @ManyToOne
    private Vehicle vehicle;

    public Journey() {
    }

    public Journey(Long id) {
        this.id = id;
    }

    // <editor-fold desc="Getters and Setters" defaultstate="collapsed">
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public List<TransLocation> getTransLocations() {
        return Collections.unmodifiableList(locations);
    }

    public long getId() {
        return id;
    }
    // </editor-fold>

    public boolean addTransLocation(TransLocation loc) {
        if (loc != null) {
            locations.add(loc);
            loc.setJourney(this);
            return true;
        }
        return false;
    }

    public boolean addTransLocation(List<TransLocation> loc) {
        if (loc != null) {
            locations.addAll(loc);
            for (TransLocation l : loc){
                l.setJourney(this);
            }
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
