package util;

import domain.Journey;
import domain.SubInvoice;
import domain.TransLocation;
import domain.Vehicle;
import dto.JourneyDTO;
import dto.SubInvoiceDTO;
import dto.TransLocationDTO;
import dto.VehicleDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Teun
 */
public class DomainToDto {

    static final String APIURL = "http://localhost:8080/Java_Backend/api/";

    public static List<VehicleDTO> VEHICLESTODTOS(List<Vehicle> vehicles) {
        List<VehicleDTO> VehicleDTOs = new ArrayList<>();
        if (vehicles == null || vehicles.isEmpty()) {
            return VehicleDTOs;
        }

        for (Vehicle v : vehicles) {
            VehicleDTO vehicle = new VehicleDTO(
                    v.getHashedLicensePlate(),
                    APIURL + "/vehicles/" + v.getHashedLicensePlate() + "/journeys",
                    v.getJourneys().size(),
                    APIURL + "/vehicles/" + v.getHashedLicensePlate() + "/invoices",
                    v.getSubInvoices().size());

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
                    s.getPrice());
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
                    APIURL + "/translocations/journeyid/" + j.getId(),
                    j.getTransLocations().size());

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
                    t.getId(),
                    t.getLat(),
                    t.getLon(),
                    t.getDateTime(),
                    t.getSerialNumber(),
                    t.getCountryCode());

            TransLocationDTOs.add(vehicle);
        }
        return TransLocationDTOs;
    }
}
