package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
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
    ,@NamedQuery(name = "SubInvoice.findByInvoiceNumber", query = "SELECT s FROM SubInvoice s WHERE s.invoiceNumber = :invoiceNumber")})
public class SubInvoice implements Serializable {

    @Id
    private Long invoiceNumber;
    private String country;
    private String paymentStatus;
    private String invoiceDate;
    private double price;
    @ManyToOne
    private Vehicle vehicle;

    public SubInvoice() {
    }

    public SubInvoice(Long invoiceNumber, String country, double price) {
        this.invoiceNumber = invoiceNumber;
        this.country = country;
        this.price = price;
        this.invoiceDate = new Date(System.currentTimeMillis()).toString();
        this.paymentStatus = "open";
    }

    public SubInvoice(Long invoiceNumber, String country, double price, String invoiceDate, String paymentStatus) {
        this.invoiceNumber = invoiceNumber;
        this.country = country;
        this.price = price;
        this.paymentStatus = paymentStatus;
        this.invoiceDate = invoiceDate;
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
    // </editor-fold>

    @Override
    public int hashCode() {
        int hash = 3;
        //hash = 97 * hash + Objects.hashCode(this.invoiceNumber);
        //hash = 97 * hash + Objects.hashCode(this.country);
        //hash = 97 * hash + Objects.hashCode(this.paymentStatus);
        //hash = 97 * hash + Objects.hashCode(this.invoiceDate);
        //hash = 97 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        //hash = 97 * hash + Objects.hashCode(this.vehicle);
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
