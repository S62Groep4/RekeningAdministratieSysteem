package domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
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
    @NamedQuery(name = "Road.findAll", query = "SELECT r FROM Road r")
    ,@NamedQuery(name = "Road.findById", query = "SELECT r FROM Road r WHERE r.id = :roadId")
    ,@NamedQuery(name = "Road.findByName", query = "SELECT r FROM Road r WHERE r.shortName = :roadName OR r.longName = :roadName")})
public class Road implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true)
    private String shortName;
    @Column(unique = true)
    private String longName;
    private Double rate;

    public Road() {
    }

    public Road(String shortName, String longName, Double rate) {
        this.shortName = shortName;
        this.longName = longName;
        this.rate = rate;
    }

    public Road(Long id, String shortName, String longName, Double rate) {
        this.id = id;
        this.shortName = shortName;
        this.longName = longName;
        this.rate = rate;
    }

    // <editor-fold desc="Getters and Setters" defaultstate="collapsed">
    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
    // </editor-fold>

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.shortName);
        hash = 17 * hash + Objects.hashCode(this.longName);
        hash = 17 * hash + Objects.hashCode(this.rate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Road other = (Road) obj;
        if (!Objects.equals(this.shortName, other.shortName)) {
            return false;
        }
        if (!Objects.equals(this.longName, other.longName)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.rate, other.rate);
    }
}
