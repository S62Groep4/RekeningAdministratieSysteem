package dto;

import java.io.Serializable;

/**
 *
 * @author Teun
 */
public class SubInvoiceDTO implements Serializable {

    private String invoiceNumber;
    private String country;
    private boolean isPayed;
    private String invoiceDate;
    private double price;

    public SubInvoiceDTO() {
    }

    public SubInvoiceDTO(String invoiceNumber, String country, boolean isPayed, String invoiceDate, double price) {
        this.invoiceNumber = invoiceNumber;
        this.country = country;
        this.isPayed = isPayed;
        this.invoiceDate = invoiceDate;
        this.price = price;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(boolean isPayed) {
        this.isPayed = isPayed;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
