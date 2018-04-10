package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Teun
 */
public class Journey implements Serializable {

    private Long id;
    private final List<TransLocation> locations = new ArrayList<>();

    public Journey() {
    }

    // <editor-fold desc="Getters and Setters" defaultstate="collapsed">
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
            return true;
        }
        return false;
    }

    public boolean addTransLocation(List<TransLocation> loc) {
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
