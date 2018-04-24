package util;

import domain.Journey;
import domain.SubInvoice;
import domain.TransLocation;
import domain.Vehicle;
import dto.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 *
 * @author Teun
 */
public class DtoToDomain {

    public static List<Vehicle> VEHICLE_DTO_TO_DOMAIN(List<VehicleDTO> vehicles) {
        List<Vehicle> domain = new ArrayList<>();
        if (vehicles == null || vehicles.isEmpty()) {
            return domain;
        }

        for (VehicleDTO v : vehicles) {
            Vehicle vehicle = new Vehicle(new String(Base64.getDecoder().decode(v.getHashedLicensePlate())));
            vehicle.addJourney(JOURNEY_DTO_TO_DOMAIN(v.getJourneys()));
            vehicle.addInvoice(SUBINVOICE_DTO_TO_DOMAIN(v.getSubInvoices()));
            domain.add(vehicle);
        }
        return domain;
    }

    public static List<SubInvoice> SUBINVOICE_DTO_TO_DOMAIN(List<SubInvoiceDTO> invoices) {
        List<SubInvoice> domain = new ArrayList<>();
        if (invoices == null || invoices.isEmpty()) {
            return domain;
        }

        for (SubInvoiceDTO s : invoices) {
            SubInvoice invoice = new SubInvoice(
                    s.getInvoiceNumber(),
                    s.getCountry(),
                    Double.parseDouble(s.getPrice()),
                    s.getInvoiceDate(),
                    s.getPaymentStatus());
            domain.add(invoice);
        }
        return domain;
    }

    public static List<Journey> JOURNEY_DTO_TO_DOMAIN(List<JourneyDTO> journeys) {
        List<Journey> domain = new ArrayList<>();
        if (journeys == null || journeys.isEmpty()) {
            return domain;
        }

        for (JourneyDTO j : journeys) {
            Journey journey = new Journey();
            journey.addTransLocation(TRANSLOCATION_DTO_TO_DOMAIN(j.getTranslocationDtos()));
            domain.add(journey);
        }
        return domain;
    }

    public static List<TransLocation> TRANSLOCATION_DTO_TO_DOMAIN(List<TransLocationDTO> locations) {
        List<TransLocation> TransLocationDTOs = new ArrayList<>();
        if (locations == null || locations.isEmpty()) {
            return TransLocationDTOs;
        }

        for (TransLocationDTO t : locations) {
            TransLocation location = new TransLocation(
                    Double.parseDouble(t.getLat()),
                    Double.parseDouble(t.getLon()),
                    t.getSerialNumber(),
                    t.getCountryCode());
            TransLocationDTOs.add(location);
        }
        return TransLocationDTOs;
    }
}
