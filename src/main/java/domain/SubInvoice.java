package domain;

import java.io.Serializable;
import java.util.Date;
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
    @NamedQuery(name = "SubInvoice.findAll", query = "SELECT s FROM SubInvoice s")
    ,@NamedQuery(name = "SubInvoice.findByInvoiceNumber", query = "SELECT s FROM SubInvoice s WHERE invoiceNumber = :invoiceNumber")})
public class SubInvoice implements ISubInvoice, Serializable {

    @Id
    private String invoiceNumber;
    private String country;
    private boolean isPayed;
    private String invoiceDate;
    private double price;

    public SubInvoice() {
    }

    public SubInvoice(String invoiceNumber, String country, double price) {
        this.invoiceNumber = invoiceNumber;
        this.country = country;
        this.price = price;
        this.isPayed = false;
        this.invoiceDate = new Date(System.currentTimeMillis()).toString();
    }

    // <editor-fold desc="Getters and Setters" defaultstate="collapsed">
    @Override
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public boolean getPaymentStatus() {
        return isPayed;
    }

    @Override
    public String getInvoiceDate() {
        return invoiceDate;
    }

    @Override
    public double getPrice() {
        return price;
    }
    // </editor-fold>

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SubInvoice)) {
            return false;
        }
        SubInvoice otherUser = (SubInvoice) obj;
        if (this.invoiceNumber == null || otherUser.invoiceNumber == null) {
            return false;
        }
        return this.invoiceNumber.equals(otherUser.invoiceNumber);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.invoiceNumber);
        hash = 73 * hash + Objects.hashCode(this.country);
        hash = 73 * hash + (this.isPayed ? 1 : 0);
        hash = 73 * hash + Objects.hashCode(this.invoiceDate);
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        return hash;
    }
}
