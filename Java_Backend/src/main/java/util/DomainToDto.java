package util;

import domain.Journey;
import domain.SubInvoice;
import domain.TransLocation;
import domain.Vehicle;
import dto.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Teun
 */
public class DomainToDto {

    public static List<VehicleDTO> VEHICLESTODTOS(List<Vehicle> vehicles) {
        List<VehicleDTO> VehicleDTOs = new ArrayList<>();
        if (vehicles == null || vehicles.isEmpty()) {
            return VehicleDTOs;
        }

        for (Vehicle v : vehicles) {
            VehicleDTO vehicle = new VehicleDTO(
                    v.getHashedLicencePlate(),
                    JOURNEYSTODTOS(v.getJourneys()),
                    SUBINVOICESSTODTOS(v.getSubInvoices()));
            VehicleDTOs.add(vehicle);
        }
        return VehicleDTOs;
    }

    public static List<SubInvoiceDTO> SUBINVOICESSTODTOS(List<SubInvoice> invoices) {
        List<SubInvoiceDTO> SubInvoiceDTOs = new ArrayList<>();
        if (invoices == null || invoices.isEmpty()) {
            return SubInvoiceDTOs;
        }

        for (SubInvoice s : invoices) {
            SubInvoiceDTO invoice = new SubInvoiceDTO(
                    s.getInvoiceNumber(),
                    s.getCountry(),
                    s.getPaymentStatus(),
                    s.getInvoiceDate(),
                    s.getPrice() + "");
            SubInvoiceDTOs.add(invoice);
        }
        return SubInvoiceDTOs;
    }

    public static List<JourneyDTO> JOURNEYSTODTOS(List<Journey> journeys) {
        List<JourneyDTO> JourneyDTOs = new ArrayList<>();
        if (journeys == null || journeys.isEmpty()) {
            return JourneyDTOs;
        }

        for (Journey j : journeys) {
            JourneyDTO journey = new JourneyDTO(
                    j.getId(),
                    TRANSLOCATIONSSTODTOS(j.getTransLocations()));
            JourneyDTOs.add(journey);
        }
        return JourneyDTOs;
    }

    public static List<TransLocationDTO> TRANSLOCATIONSSTODTOS(List<TransLocation> locations) {
        List<TransLocationDTO> TransLocationDTOs = new ArrayList<>();
        if (locations == null || locations.isEmpty()) {
            return TransLocationDTOs;
        }

        for (TransLocation t : locations) {
            TransLocationDTO vehicle = new TransLocationDTO(
                    t.getLat() + "",
                    t.getLon() + "",
                    t.getDateTime(),
                    t.getSerialNumber(),
                    t.getCountryCode());
            TransLocationDTOs.add(vehicle);
        }
        return TransLocationDTOs;
    }
}
