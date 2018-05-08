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
public class DomainToDto {

    private static String apiUri = "http://localhost:8080/Java_Backend/api/";

    public static List<VehicleDTO> VEHICLESTODTOS(List<Vehicle> vehicles) {
        List<VehicleDTO> vehicleDTOs = new ArrayList<>();
        if (vehicles == null || vehicles.isEmpty()) {
            return vehicleDTOs;
        }

        for (Vehicle vehicle : vehicles) {
            VehicleDTO vehicleDTO = new VehicleDTO(
                    vehicle.getHashedLicencePlate(),
                    apiUri + "vehicles/" + new String(Base64.getEncoder().encode(vehicle.getHashedLicencePlate().getBytes())) + "/journeys",
                    apiUri + "vehicles/" + new String(Base64.getEncoder().encode(vehicle.getHashedLicencePlate().getBytes())) + "/invoices");
            vehicleDTOs.add(vehicleDTO);
        }
        return vehicleDTOs;
    }

    public static VehicleDTO VEHICLESTODTOS(Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO(null, null, null);
        if (vehicle == null) {
            return vehicleDTO;
        }

        vehicleDTO = new VehicleDTO(
                vehicle.getHashedLicencePlate(),
                apiUri + "vehicles/" + new String(Base64.getEncoder().encode(vehicle.getHashedLicencePlate().getBytes())) + "/journeys",
                apiUri + "vehicles/" + new String(Base64.getEncoder().encode(vehicle.getHashedLicencePlate().getBytes())) + "/invoices");
        return vehicleDTO;
    }

    public static List<SubInvoiceDTO> SUBINVOICESTODTOS(List<SubInvoice> invoices) {
        List<SubInvoiceDTO> subInvoiceDTOs = new ArrayList<>();
        if (invoices == null || invoices.isEmpty()) {
            return subInvoiceDTOs;
        }

        for (SubInvoice s : invoices) {
            SubInvoiceDTO invoice = new SubInvoiceDTO(
                    s.getInvoiceNumber(),
                    s.getCountry(),
                    s.getPaymentStatus(),
                    s.getInvoiceDate(),
                    s.getPrice() + "");
            subInvoiceDTOs.add(invoice);
        }
        return subInvoiceDTOs;
    }

    public static SubInvoiceDTO SUBINVOICESTODTOS(SubInvoice subInvoice) {
        SubInvoiceDTO subInvoiceDTO = new SubInvoiceDTO(null, null, null, null, null);
        if (subInvoice == null) {
            return subInvoiceDTO;
        }

        subInvoiceDTO = new SubInvoiceDTO(subInvoice.getInvoiceNumber(),
                subInvoice.getCountry(),
                subInvoice.getPaymentStatus(),
                subInvoice.getInvoiceDate(),
                subInvoice.getPrice() + "");
        return subInvoiceDTO;
    }

    public static List<JourneyDTO> JOURNEYSTODTOS(List<Journey> journeys) {
        List<JourneyDTO> journeyDTOs = new ArrayList<>();
        if (journeys == null || journeys.isEmpty()) {
            return journeyDTOs;
        }

        for (Journey j : journeys) {
            JourneyDTO journey = new JourneyDTO(
                    j.getId(),
                    apiUri + "translocations/journeyid/" + j.getId());
            journeyDTOs.add(journey);
        }
        return journeyDTOs;
    }

    public static JourneyDTO JOURNEYSTODTOS(Journey journey) {
        JourneyDTO journeyDTO = new JourneyDTO(null, null);
        if (journey == null) {
            return journeyDTO;
        }

        journeyDTO = new JourneyDTO(journey.getId(),
                apiUri + "translocations/journeyid/" + journey.getId());
        return journeyDTO;
    }

    public static List<TransLocationDTO> TRANSLOCATIONSTODTOS(List<TransLocation> locations) {
        List<TransLocationDTO> transLocationDTOs = new ArrayList<>();
        if (locations == null || locations.isEmpty()) {
            return transLocationDTOs;
        }

        for (TransLocation t : locations) {
            TransLocationDTO transLocation = new TransLocationDTO(
                    t.getLat(),
                    t.getLon(),
                    t.getDateTime(),
                    t.getSerialNumber(),
                    t.getCountryCode());
            transLocationDTOs.add(transLocation);
        }
        return transLocationDTOs;
    }

    public static TransLocationDTO TRANSLOCATIONSTODTOS(TransLocation location) {
        TransLocationDTO transLocationDTO = new TransLocationDTO(null, null, null, null, null);
        if (location == null) {
            return transLocationDTO;
        }

        transLocationDTO = new TransLocationDTO(
                location.getLat(),
                location.getLon(),
                location.getDateTime(),
                location.getSerialNumber(),
                location.getCountryCode());
        return transLocationDTO;
    }
}
