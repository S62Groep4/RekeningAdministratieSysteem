package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Teun
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v")
    ,@NamedQuery(name = "Vehicle.findByLicenceplate", query = "SELECT v FROM Vehicle v WHERE v.hashedLicencePlate = :hashedLicencePlate")
    ,@NamedQuery(name = "Vehicle.findJourneys", query = "SELECT t FROM TransLocation t WHERE t.journeyId IN (SELECT v.journeys FROM Vehicle v WHERE v.hashedLicencePlate = :hashedLicencePlate)")
    ,@NamedQuery(name = "Vehicle.findInvoices", query = "SELECT v.subInvoices from Vehicle v WHERE v.hashedLicencePlate = :hashedLicencePlate")})
public class Vehicle implements Serializable {

    @Id
    private String hashedLicencePlate;
    private final List<Integer> journeys = new ArrayList<>();
    @OneToMany
    private final List<SubInvoice> subInvoices = new ArrayList<>();

    public Vehicle() {
    }

    public Vehicle(String licencePlate) {
        this.hashedLicencePlate = BCrypt.hashpw(licencePlate, BCrypt.gensalt(12));
    }

    // <editor-fold desc="Getters and Setters" defaultstate="collapsed">
    public String getHashedLicensePlate() {
        return hashedLicencePlate;
    }

    public void setHashedLicencePlate(String hashedLicencePlate) {
        this.hashedLicencePlate = hashedLicencePlate;
    }

    public List<Integer> getJourneys() {
        return Collections.unmodifiableList(journeys);
    }

    public List<SubInvoice> getSubInvoices() {
        return Collections.unmodifiableList(subInvoices);
    }
    // </editor-fold>

    public boolean addJourney(int j) {
        journeys.add(j);
        return true;
    }

    public boolean addJourney(List<Integer> j) {
        journeys.addAll(j);
        return true;
    }

    public boolean addInvoice(SubInvoice i) {
        if (i != null) {
            subInvoices.add(i);
            return true;
        }
        return false;
    }

    public boolean addInvoice(List<SubInvoice> i) {
        if (i != null) {
            subInvoices.addAll(i);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vehicle)) {
            return false;
        }
        Vehicle otherUser = (Vehicle) obj;
        if (this.hashedLicencePlate == null || otherUser.hashedLicencePlate == null) {
            return false;
        }
        return this.hashedLicencePlate.equals(otherUser.hashedLicencePlate);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.hashedLicencePlate);
        hash = 83 * hash + Objects.hashCode(this.journeys);
        hash = 83 * hash + Objects.hashCode(this.subInvoices);
        return hash;
    }
}
