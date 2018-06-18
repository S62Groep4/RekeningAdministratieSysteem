package domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Teun
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "SubInvoice.findAll", query = "SELECT s FROM SubInvoice s")
    ,@NamedQuery(name = "SubInvoice.findByInvoiceNumber", query = "SELECT s FROM SubInvoice s WHERE s.invoiceNumber = :invoiceNumber"),
})
public class SubInvoice implements Serializable {

    private static final DateFormat DF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long invoiceNumber;
    private String country;
    private String paymentStatus;
    private String invoiceDate;
    private double price;
    @ManyToOne
    private Vehicle vehicle;
    private final List<Journey> journeys = new ArrayList<>();

    public SubInvoice() {
    }

    public SubInvoice(Long invoiceNumber, String country, double price) {
        this.invoiceNumber = invoiceNumber;
        this.country = country;
        this.price = price;
        this.invoiceDate = DF.format(new Date());
        this.paymentStatus = "OPEN";
    }

    public SubInvoice(Long invoiceNumber, String country, double price, String invoiceDate) {
        this.invoiceNumber = invoiceNumber;
        this.country = country;
        this.price = price;
        this.invoiceDate = invoiceDate;
        this.paymentStatus = "OPEN";
    }

    public SubInvoice(Long invoiceNumber, String country, double price, String invoiceDate, List<Journey> journeys) {
        this.invoiceNumber = invoiceNumber;
        this.country = country;
        this.price = price;
        this.invoiceDate = invoiceDate;
        this.paymentStatus = "OPEN";
        this.journeys.addAll(journeys);
    }
    
    public void removeJourneys() {
        journeys.clear();
    }

    // <editor-fold desc="Getters and Setters" defaultstate="collapsed">
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setInvoiceNumber(Long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Long getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public double getPrice() {
        return price;
    }
    
    public void addJourneys(List<Journey> journeys) {
        this.journeys.addAll(journeys);
    }
    
    public List<Journey> getJourneys() {
        return Collections.unmodifiableList(journeys);
    }
    // </editor-fold>

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.invoiceNumber);
        hash = 97 * hash + Objects.hashCode(this.country);
        hash = 97 * hash + Objects.hashCode(this.paymentStatus);
        hash = 97 * hash + Objects.hashCode(this.invoiceDate);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
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
        final SubInvoice other = (SubInvoice) obj;
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        if (!Objects.equals(this.paymentStatus, other.paymentStatus)) {
            return false;
        }
        if (!Objects.equals(this.invoiceDate, other.invoiceDate)) {
            return false;
        }
        if (!Objects.equals(this.invoiceNumber, other.invoiceNumber)) {
            return false;
        }
        return Objects.equals(this.vehicle, other.vehicle);
    }
}
