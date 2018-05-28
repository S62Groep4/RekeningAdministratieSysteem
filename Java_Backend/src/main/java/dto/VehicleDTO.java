package dto;

import java.io.Serializable;

/**
 *
 * @author Teun
 */
public class VehicleDTO implements Serializable {

    private String hashedLicensePlate;
    private String journeyUri;
    private String subInvoiceUri;
    private String ownerUri;
    private String carTrackerId;

    public VehicleDTO() {
    }

    public VehicleDTO(String hashedLicensePlate, String journeyUri, String subInvoiceUri, String ownerUri, String carTrackerId) {
        this.hashedLicensePlate = hashedLicensePlate;
        this.journeyUri = journeyUri;
        this.subInvoiceUri = subInvoiceUri;
        this.ownerUri = ownerUri;
        this.carTrackerId = carTrackerId;
    }

    public String getCarTrackerId() {
        return carTrackerId;
    }

    public void setCarTrackerId(String carTrackerId) {
        this.carTrackerId = carTrackerId;
    }

    public String getOwnerUri() {
        return ownerUri;
    }

    public void setOwnerUri(String ownerUri) {
        this.ownerUri = ownerUri;
    }

    public void setHashedLicensePlate(String hashedLicensePlate) {
        this.hashedLicensePlate = hashedLicensePlate;
    }

    public void setJourneyUri(String journeyUri) {
        this.journeyUri = journeyUri;
    }

    public void setSubInvoiceUri(String subInvoiceUri) {
        this.subInvoiceUri = subInvoiceUri;
    }

    public String getHashedLicensePlate() {
        return hashedLicensePlate;
    }

    public String getJourneyUri() {
        return journeyUri;
    }

    public String getSubInvoiceUri() {
        return subInvoiceUri;
    }
}
