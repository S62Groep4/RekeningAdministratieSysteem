package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Teun
 */
@Entity
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
        int hash = 7;
        hash = 66 * hash + Objects.hashCode(this.invoiceNumber);
        hash = 66 * hash + Objects.hashCode(this.country);
        hash = 66 * hash + Objects.hashCode(this.isPayed);
        hash = 66 * hash + Objects.hashCode(this.invoiceDate);
        hash = 66 * hash + Objects.hashCode(this.price);
        return hash;
    }
}
