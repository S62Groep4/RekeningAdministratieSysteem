package util;

import domain.Journey;
import domain.SubInvoice;
import domain.TransLocation;
import domain.Vehicle;
import dto.eu.JourneyDTO_EU;
import dto.eu.SubInvoiceDTO_EU;
import dto.eu.TransLocationDTO_EU;
import dto.eu.VehicleDTO_EU;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 *
 * @author Teun
 */
public class Dto_EUToDomain {

    public static List<Vehicle> VEHICLE_EU_DTO_TO_DOMAIN(List<VehicleDTO_EU> vehicles) {
        List<Vehicle> domain = new ArrayList<>();
        if (vehicles == null || vehicles.isEmpty()) {
            return domain;
        }

        for (VehicleDTO_EU v : vehicles) {
            Vehicle vehicle = new Vehicle(new String(Base64.getDecoder().decode(v.getHashedLicencePlate())));
//            vehicle.addJourney(); http call naar v.getJourneyUrl()
//            vehicle.addInvoice(); http call naar v.getSubInvoiceUrl()
            domain.add(vehicle);
        }
        return domain;
    }

    public static List<SubInvoice> SUBINVOICE_EU_DTO_TO_DOMAIN(List<SubInvoiceDTO_EU> invoices) {
        List<SubInvoice> domain = new ArrayList<>();
        if (invoices == null || invoices.isEmpty()) {
            return domain;
        }

        for (SubInvoiceDTO_EU s : invoices) {
            SubInvoice invoice = new SubInvoice(s.getInvoiceNumber(), s.getCountry(), s.getPrice(), s.getInvoiceDate(), s.getIsPayed());
            domain.add(invoice);
        }
        return domain;
    }

    public static List<Journey> JOURNEY_EU_DTO_TO_DOMAIN(List<JourneyDTO_EU> journeys) {
        List<Journey> domain = new ArrayList<>();
        if (journeys == null || journeys.isEmpty()) {
            return domain;
        }

        for (JourneyDTO_EU j : journeys) {
            Journey journey = new Journey(j.getId());
//            journey.addTransLocation(loc) http call naar j.getTranslocationUrl()
            domain.add(journey);
        }
        return domain;
    }

    public static List<TransLocation> TRANSLOCATION_EU_DTO_TO_DOMAIN(List<TransLocationDTO_EU> locations) {
        List<TransLocation> TransLocationDTOs = new ArrayList<>();
        if (locations == null || locations.isEmpty()) {
            return TransLocationDTOs;
        }

        for (TransLocationDTO_EU t : locations) {
            TransLocation location = new TransLocation(t.getLat(), t.getLon(), t.getSerialNumber(), t.getCountryCode());
            TransLocationDTOs.add(location);
        }
        return TransLocationDTOs;
    }
}
