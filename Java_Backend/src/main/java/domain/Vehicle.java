package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import static javax.persistence.CascadeType.ALL;
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
    ,@NamedQuery(name = "Vehicle.findJourneys", query = "SELECT j FROM Journey j WHERE j.vehicle.hashedLicencePlate IN (SELECT v.hashedLicencePlate FROM Vehicle v WHERE v.hashedLicencePlate = :hashedLicencePlate)")
    ,@NamedQuery(name = "Vehicle.findInvoices", query = "SELECT i FROM SubInvoice i WHERE i.vehicle.hashedLicencePlate IN (SELECT v.hashedLicencePlate FROM Vehicle v WHERE v.hashedLicencePlate = :hashedLicencePlate)")})
public class Vehicle implements Serializable {

    @Id
    private String hashedLicencePlate;
    @OneToMany(mappedBy = "vehicle", cascade = ALL)
    private final List<Journey> journeys = new ArrayList<>();
    @OneToMany(mappedBy = "vehicle", cascade = ALL)
    private final List<SubInvoice> subInvoices = new ArrayList<>();

    public Vehicle() {
    }

    public Vehicle(String licencePlate) {
        this.hashedLicencePlate = licencePlate;
    }

    // <editor-fold desc="Getters and Setters" defaultstate="collapsed">
    public void setHashedLicencePlate(String hashedLicencePlate) {
        this.hashedLicencePlate = hashedLicencePlate;
    }

    public void setUnHashedLicencePlate(String licencePlate) {
        this.hashedLicencePlate = BCrypt.hashpw(licencePlate, BCrypt.gensalt(12));
    }

    public String getHashedLicencePlate() {
        return hashedLicencePlate;
    }

    public List<Journey> getJourneys() {
        return Collections.unmodifiableList(journeys);
    }

    public List<SubInvoice> getSubInvoices() {
        return Collections.unmodifiableList(subInvoices);
    }
    // </editor-fold>

    public boolean addJourney(Journey j) {
        if (j != null) {
            journeys.add(j);
            j.setVehicle(this);
            return true;
        }
        return false;
    }

    public boolean addJourney(List<Journey> j) {
        if (j != null) {
            journeys.addAll(j);
            for (Journey jou : journeys) {
                jou.setVehicle(this);
            }
            return true;
        }
        return false;
    }

    public boolean addInvoice(SubInvoice i) {
        if (i != null) {
            subInvoices.add(i);
            i.setVehicle(this);
            return true;
        }
        return false;
    }

    public boolean addInvoice(List<SubInvoice> i) {
        if (i != null) {
            subInvoices.addAll(i);
            for (SubInvoice s : subInvoices) {
                s.setVehicle(this);
            }
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
