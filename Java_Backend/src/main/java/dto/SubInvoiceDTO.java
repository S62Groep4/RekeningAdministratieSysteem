package dto;

import java.io.Serializable;

/**
 *
 * @author Teun
 */
public class SubInvoiceDTO implements Serializable {

    private String invoiceNumber;
    private String country;
    private String paymentStatus;
    private String invoiceDate;
    private String price;

    public SubInvoiceDTO(String invoiceNumber, String country, String paymentStatus, String invoiceDate, String price) {
        this.invoiceNumber = invoiceNumber;
        this.country = country;
        this.paymentStatus = paymentStatus;
        this.invoiceDate = invoiceDate;
        this.price = price;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public String getPrice() {
        return price;
    }
}
