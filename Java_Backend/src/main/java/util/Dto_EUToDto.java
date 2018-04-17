package util;

import dto.JourneyDTO;
import dto.SubInvoiceDTO;
import dto.TransLocationDTO;
import dto.VehicleDTO;
import dto.eu.JourneyDTO_EU;
import dto.eu.SubInvoiceDTO_EU;
import dto.eu.TransLocationDTO_EU;
import dto.eu.VehicleDTO_EU;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Teun
 */
public class Dto_EUToDto {

    public static List<VehicleDTO> VEHICLEEUDTOTODTO(List<VehicleDTO_EU> vehicles) {
        List<VehicleDTO> euDTOs = new ArrayList<>();
        if (vehicles == null || vehicles.isEmpty()) {
            return euDTOs;
        }

        for (VehicleDTO_EU v : vehicles) {
            VehicleDTO vehicle = new VehicleDTO(
                    v.getHashedLicencePlate(),
                    v.getJourneyUrl(),
                    v.getJourneys(),
                    v.getSubInvoiceUrl(),
                    v.getSubInvoices());

            euDTOs.add(vehicle);
        }
        return euDTOs;
    }

    public static List<SubInvoiceDTO> SUBINVOICEEUDTOTODTO(List<SubInvoiceDTO_EU> invoices) {
        List<SubInvoiceDTO> euDTOs = new ArrayList<>();
        if (invoices == null || invoices.isEmpty()) {
            return euDTOs;
        }

        for (SubInvoiceDTO_EU s : invoices) {
            SubInvoiceDTO invoice = new SubInvoiceDTO(
                    s.getInvoiceNumber(),
                    s.getCountry(),
                    s.getIsPayed(),
                    s.getInvoiceDate(),
                    s.getPrice());
            euDTOs.add(invoice);
        }
        return euDTOs;
    }

    public static List<JourneyDTO> JOURNEYEUDTOTODTO(List<JourneyDTO_EU> journeys) {
        List<JourneyDTO> euDTOs = new ArrayList<>();
        if (journeys == null || journeys.isEmpty()) {
            return euDTOs;
        }

        for (JourneyDTO_EU j : journeys) {
            JourneyDTO journey = new JourneyDTO(
                    j.getId(),
                    j.getTranslocationUrl(),
                    j.getTranslocations());
            euDTOs.add(journey);
        }
        return euDTOs;
    }

    public static List<TransLocationDTO> TRANSLOCATIONEUDTOTODTO(List<TransLocationDTO_EU> locations) {
        List<TransLocationDTO> TransLocationDTOs = new ArrayList<>();
        if (locations == null || locations.isEmpty()) {
            return TransLocationDTOs;
        }

        for (TransLocationDTO_EU t : locations) {
            TransLocationDTO location = new TransLocationDTO(
                    t.getId(),
                    t.getLat(),
                    t.getLon(),
                    t.getDateTime(),
                    t.getSerialNumber(),
                    t.getCountryCode());
            TransLocationDTOs.add(location);
        }
        return TransLocationDTOs;
    }
}
