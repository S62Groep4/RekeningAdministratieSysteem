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
    ,@NamedQuery(name = "Road.findByName", query = "SELECT r FROM Road r WHERE r.name = :roadName")
    ,@NamedQuery(name = "Road.searchByName", query = "SELECT r FROM Road r WHERE r.name LIKE :roadName")})
public class Road implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true)
    private String name;
    private Double rate;

    public Road() {
    }

    public Road(String name, Double rate) {
        this.name = name;
        this.rate = rate;
    }

    public Road(Long id, String name, Double rate) {
        this.id = id;
        this.name = name;
        this.rate = rate;
    }

    // <editor-fold desc="Getters and Setters" defaultstate="collapsed">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.rate);
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
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.rate, other.rate);
    }
}
