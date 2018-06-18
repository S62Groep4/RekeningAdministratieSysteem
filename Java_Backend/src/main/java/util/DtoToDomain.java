package util;

import domain.*;
import dto.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 *
 * @author Teun
 */
public class DtoToDomain {

    public static List<Vehicle> VEHICLE_DTO_TO_DOMAIN(List<VehicleDTO> vehicleDTOs) {
        List<Vehicle> vehicles = new ArrayList<>();
        if (vehicleDTOs == null || vehicleDTOs.isEmpty()) {
            return vehicles;
        }

        for (VehicleDTO v : vehicleDTOs) {
            Vehicle vehicle = new Vehicle(
                    new String(Base64.getDecoder().decode(v.getHashedLicensePlate())),
                    v.getCarTrackerId());
            vehicles.add(vehicle);
        }
        return vehicles;
    }

    public static Vehicle VEHICLE_DTO_TO_DOMAIN(VehicleDTO vehicleDTO) {
        if (vehicleDTO == null) {
            return new Vehicle();
        }
        return new Vehicle(
                new String(Base64.getDecoder().decode(vehicleDTO.getHashedLicensePlate())),
                vehicleDTO.getCarTrackerId());
    }

    public static List<SubInvoice> SUBINVOICE_DTO_TO_DOMAIN(List<SubInvoiceDTO> invoiceDTOs) {
        List<SubInvoice> invoices = new ArrayList<>();
        if (invoiceDTOs == null || invoiceDTOs.isEmpty()) {
            return invoices;
        }

        for (SubInvoiceDTO s : invoiceDTOs) {
            SubInvoice invoice = new SubInvoice(
                    s.getInvoiceNumber(),
                    s.getCountry(),
                    Double.parseDouble(s.getPrice()),
                    s.getInvoiceDate());
            invoice.setPaymentStatus(s.getPaymentStatus());
            invoices.add(invoice);
        }
        return invoices;
    }

    public static SubInvoice SUBINVOICE_DTO_TO_DOMAIN(SubInvoiceDTO invoiceDTO) {
        if (invoiceDTO == null) {
            return new SubInvoice();
        }
        SubInvoice invoice = new SubInvoice(
                invoiceDTO.getInvoiceNumber(),
                invoiceDTO.getCountry(),
                Double.parseDouble(invoiceDTO.getPrice()),
                invoiceDTO.getInvoiceDate());
        invoice.setPaymentStatus(invoiceDTO.getPaymentStatus());
        return invoice;
    }

    public static List<Journey> JOURNEY_DTO_TO_DOMAIN(List<JourneyDTO> journeyDTOs) {
        List<Journey> journeys = new ArrayList<>();
        if (journeyDTOs == null || journeyDTOs.isEmpty()) {
            return journeys;
        }

        for (JourneyDTO j : journeyDTOs) {
            Journey journey = new Journey(j.getId());
            journeys.add(journey);
        }
        return journeys;
    }

    public static Journey JOURNEY_DTO_TO_DOMAIN(JourneyDTO journeyDTO) {
        if (journeyDTO == null) {
            return new Journey();
        }

        return new Journey(journeyDTO.getId());
    }

    public static List<TransLocation> TRANSLOCATION_DTO_TO_DOMAIN(List<TransLocationDTO> locationDTOs) {
        List<TransLocation> translocations = new ArrayList<>();
        if (locationDTOs == null || locationDTOs.isEmpty()) {
            return translocations;
        }

        for (TransLocationDTO t : locationDTOs) {
            TransLocation location = new TransLocation(
                    t.getLat(),
                    t.getLon(),
                    t.getCarTrackerId(),
                    t.getCountryCode());
            translocations.add(location);
        }
        return translocations;
    }

    public static TransLocation TRANSLOCATION_DTO_TO_DOMAIN(TransLocationDTO locationDTO) {
        if (locationDTO == null) {
            return new TransLocation();
        }

        return new TransLocation(
                locationDTO.getLat(),
                locationDTO.getLon(),
                locationDTO.getCarTrackerId(),
                locationDTO.getCountryCode());
    }

    public static List<Road> ROAD_DTO_TO_DOMAIN(List<RoadDTO> roadDTOs) {
        List<Road> roads = new ArrayList<>();
        if (roadDTOs == null || roadDTOs.isEmpty()) {
            return roads;
        }

        for (RoadDTO r : roadDTOs) {
            Road road = new Road(
                    r.getId(),
                    r.getShortName(),
                    r.getLongName(),
                    r.getRate());
            roads.add(road);
        }
        return roads;
    }

    public static Road ROAD_DTO_TO_DOMAIN(RoadDTO roadDTO) {
        if (roadDTO == null) {
            return new Road();
        }

        return new Road(
                roadDTO.getId(),
                roadDTO.getShortName(),
                roadDTO.getLongName(),
                roadDTO.getRate());
    }

    public static List<Person> PERSON_DTO_TO_DOMAIN(List<PersonDTO> personDTOs) {
        List<Person> persons = new ArrayList<>();
        if (personDTOs == null || personDTOs.isEmpty()) {
            return persons;
        }

        for (PersonDTO p : personDTOs) {
            Person person = new Person(
                    p.getId(),
                    p.getFirstName(),
                    p.getLastName());
            persons.add(person);
        }
        return persons;
    }

    public static Person PERSON_DTO_TO_DOMAIN(PersonDTO personDTO) {
        if (personDTO == null) {
            return new Person();
        }

        return new Person(
                personDTO.getId(),
                personDTO.getFirstName(),
                personDTO.getLastName());
    }

    public static List<Address> ADDRESS_DTO_TO_DOMAIN(List<AddressDTO> addressDTOS) {
        List<Address> addresses = new ArrayList<>();
        if (addressDTOS == null || addressDTOS.isEmpty()) {
            return addresses;
        }

        for (AddressDTO a : addressDTOS) {
            Address address = new Address(
                    a.getId(),
                    a.getStreetName(),
                    a.getStreetNumber(),
                    a.getZipCode(),
                    a.getCity(),
                    a.getCountry()
            );
            addresses.add(address);
        }
        return addresses;
    }

    public static Address ADDRESS_DTO_TO_DOMAIN(AddressDTO addressDTO) {
        if (addressDTO == null) {
            return new Address();
        }

        return new Address(
                addressDTO.getId(),
                addressDTO.getStreetName(),
                addressDTO.getStreetNumber(),
                addressDTO.getZipCode(),
                addressDTO.getCity(),
                addressDTO.getCountry());
    }
}
