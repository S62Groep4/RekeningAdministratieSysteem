package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Teun
 */
@Entity
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

    @Override
    public String getHashedLicensePlate() {
        return hashedLicencePlate;
    }

    @Override
    public List<IJourney> getJourneys() {
        return Collections.unmodifiableList(journeys);
    }

    @Override
    public List<ISubInvoice> getSubInvoices() {
        return Collections.unmodifiableList(subInvoices);
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
        hash = 53 * hash + Objects.hashCode(this.hashedLicencePlate);
        hash = 53 * hash + Objects.hashCode(this.journeys);
        hash = 53 * hash + Objects.hashCode(this.subInvoices);
        return hash;
    }
}
