package dto;

import java.io.Serializable;

/**
 *
 * @author Teun
 */
public class SubInvoiceDTO implements Serializable {

    private final String invoiceNumber;
    private final String country;
    private final String paymentStatus;
    private final String invoiceDate;
    private final String price;

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
