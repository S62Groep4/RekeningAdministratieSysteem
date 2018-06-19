package dto;

import java.io.Serializable;

/**
 *
 * @author Teun
 */
public class SubInvoiceDTO implements Serializable {

    private Long invoiceNumber;
    private String country;
    private String paymentStatus;
    private String invoiceDate;
    private String price;
    private String ownerUri;
    private String carTrackerId;

    public SubInvoiceDTO() {
    }

    public SubInvoiceDTO(Long invoiceNumber, String country, String paymentStatus, String invoiceDate, String price, String ownerUri, String carTrackerId) {
        this.invoiceNumber = invoiceNumber;
        this.country = country;
        this.paymentStatus = paymentStatus;
        this.invoiceDate = invoiceDate;
        this.price = price;
        this.ownerUri = ownerUri;
        this.carTrackerId = carTrackerId;
    }

    public String getOwnerUri() {
        return ownerUri;
    }

    public void setOwnerUri(String ownerUri) {
        this.ownerUri = ownerUri;
    }

    public void setInvoiceNumber(Long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getInvoiceNumber() {
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

    public String getCarTrackerId() {
        return carTrackerId;
    }

    public void setCarTrackerId(String carTrackerId) {
        this.carTrackerId = carTrackerId;
    }
}
