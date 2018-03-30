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

/**
 *
 * @author Teun
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v")
    ,@NamedQuery(name = "Vehicle.findByLicenceplate", query = "SELECT v FROM Vehicle v WHERE v.hashedLicencePlate = :hashedLicencePlate")})
public class Vehicle implements IVehicle, Serializable {

    @Id
    private String hashedLicencePlate;
    private final List<IJourney> journeys = new ArrayList<>();
    private final List<ISubInvoice> subInvoices = new ArrayList<>();

    public Vehicle() {
    }

    public Vehicle(String hashedLicencePlate) {
        this.hashedLicencePlate = hashedLicencePlate;
    }

    // <editor-fold desc="Getters and Setters" defaultstate="collapsed">
    @Override
    public String getHashedLicensePlate() {
        return hashedLicencePlate;
    }

    public void setHashedLicencePlate(String hashedLicencePlate) {
        this.hashedLicencePlate = hashedLicencePlate;
    }

    @Override
    public List<IJourney> getJourneys() {
        return Collections.unmodifiableList(journeys);
    }

    @Override
    public List<ISubInvoice> getSubInvoices() {
        return Collections.unmodifiableList(subInvoices);
    }
    // </editor-fold>

    public boolean addJourney(IJourney j) {
        if (j != null) {
            journeys.add(j);
            return true;
        }
        return false;
    }

    public boolean addJourney(List<IJourney> j) {
        if (j != null) {
            journeys.addAll(j);
            return true;
        }
        return false;
    }

    public boolean addInvoice(ISubInvoice i) {
        if (i != null) {
            subInvoices.add(i);
            return true;
        }
        return false;
    }

    public boolean addInvoice(List<ISubInvoice> i) {
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
