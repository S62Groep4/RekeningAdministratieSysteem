package dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Teun
 */
public class VehicleDTO implements Serializable {

    private final String HashedLicensePlate;
    private final List<JourneyDTO> Journeys;
    private final List<SubInvoiceDTO> SubInvoices;

    public VehicleDTO(String hashedLicensePlate, List<JourneyDTO> journeys, List<SubInvoiceDTO> subInvoices) {
        HashedLicensePlate = hashedLicensePlate;
        Journeys = journeys;
        SubInvoices = subInvoices;
    }

    public String getHashedLicensePlate() {
        return HashedLicensePlate;
    }

    public List<JourneyDTO> getJourneys() {
        return Journeys;
    }

    public List<SubInvoiceDTO> getSubInvoices() {
        return SubInvoices;
    }
}
