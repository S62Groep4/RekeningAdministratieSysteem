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
public class DtoToDto_EU {

    public static List<VehicleDTO_EU> VEHICLEDTOSTOEU(List<VehicleDTO> vehicles) {
        List<VehicleDTO_EU> euDTOs = new ArrayList<>();
        if (vehicles == null || vehicles.isEmpty()) {
            return euDTOs;
        }

        for (VehicleDTO v : vehicles) {
            VehicleDTO_EU vehicle = new VehicleDTO_EU(
                    v.getHashedLicencePlate(),
                    v.getJourneyUrl(),
                    v.getJourneys(),
                    v.getSubInvoiceUrl(),
                    v.getSubInvoices());

            euDTOs.add(vehicle);
        }
        return euDTOs;
    }

    public static List<SubInvoiceDTO_EU> SUBINVOICEDTOSSTOEU(List<SubInvoiceDTO> invoices) {
        List<SubInvoiceDTO_EU> euDTOs = new ArrayList<>();
        if (invoices == null || invoices.isEmpty()) {
            return euDTOs;
        }

        for (SubInvoiceDTO s : invoices) {
            SubInvoiceDTO_EU invoice = new SubInvoiceDTO_EU(
                    s.getInvoiceNumber(),
                    s.getCountry(),
                    s.getIsPayed(),
                    s.getInvoiceDate(),
                    s.getPrice());
            euDTOs.add(invoice);
        }
        return euDTOs;
    }

    public static List<JourneyDTO_EU> JOURNEYDTOSTOEU(List<JourneyDTO> journeys) {
        List<JourneyDTO_EU> euDTOs = new ArrayList<>();
        if (journeys == null || journeys.isEmpty()) {
            return euDTOs;
        }

        for (JourneyDTO j : journeys) {
            JourneyDTO_EU journey = new JourneyDTO_EU(
                    j.getId(),
                    j.getTranslocationUrl(),
                    j.getTranslocations());
            euDTOs.add(journey);
        }
        return euDTOs;
    }

    public static List<TransLocationDTO_EU> TRANSLOCATIONDTOSTOEU(List<TransLocationDTO> locations) {
        List<TransLocationDTO_EU> TransLocationDTOs = new ArrayList<>();
        if (locations == null || locations.isEmpty()) {
            return TransLocationDTOs;
        }

        for (TransLocationDTO t : locations) {
            TransLocationDTO_EU location = new TransLocationDTO_EU(
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
