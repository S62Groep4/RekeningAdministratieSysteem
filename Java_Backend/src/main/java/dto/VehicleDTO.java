package dto;

import java.io.Serializable;
import java.util.Base64;

/**
 *
 * @author Teun
 */
public class VehicleDTO implements Serializable {

    private String hashedLicencePlate;
    private String journeyUrl;
    private int journeys;
    private String subInvoiceUrl;
    private int subInvoices;

    public VehicleDTO() {
    }

    public VehicleDTO(String hashedLicencePlate, String journeyUrl, int journeys, String subInvoiceUrl, int subInvoices) {
        this.hashedLicencePlate = new String(Base64.getEncoder().encode(hashedLicencePlate.getBytes()));
        this.journeyUrl = journeyUrl;
        this.journeys = journeys;
        this.subInvoiceUrl = subInvoiceUrl;
        this.subInvoices = subInvoices;
    }

    public String getHashedLicencePlate() {
        return hashedLicencePlate;
    }

    public void setHashedLicencePlate(String hashedLicencePlate) {
        this.hashedLicencePlate = hashedLicencePlate;
    }

    public String getJourneyUrl() {
        return journeyUrl;
    }

    public void setJourneyUrl(String journeyUrl) {
        this.journeyUrl = journeyUrl;
    }

    public int getJourneys() {
        return journeys;
    }

    public void setJourneys(int journeys) {
        this.journeys = journeys;
    }

    public String getSubInvoiceUrl() {
        return subInvoiceUrl;
    }

    public void setSubInvoiceUrl(String subInvoiceUrl) {
        this.subInvoiceUrl = subInvoiceUrl;
    }

    public int getSubInvoices() {
        return subInvoices;
    }

    public void setSubInvoices(int subInvoices) {
        this.subInvoices = subInvoices;
    }

}
