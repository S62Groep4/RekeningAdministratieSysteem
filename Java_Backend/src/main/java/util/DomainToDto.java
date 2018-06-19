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
public class DomainToDto {

    private static final String APIURI = "http://192.168.24.91:8080/RekeningAdministratieSysteem/api/";

    public static List<VehicleDTO> VEHICLESTODTOS(List<Vehicle> vehicles) {
        List<VehicleDTO> vehicleDTOs = new ArrayList<>();
        if (vehicles == null || vehicles.isEmpty()) {
            return vehicleDTOs;
        }

        for (Vehicle vehicle : vehicles) {
            VehicleDTO vehicleDTO = new VehicleDTO(
                    vehicle.getHashedLicencePlate(),
                    APIURI + "vehicles/" + new String(Base64.getEncoder().encode(vehicle.getHashedLicencePlate().getBytes())) + "/journeys",
                    APIURI + "vehicles/" + new String(Base64.getEncoder().encode(vehicle.getHashedLicencePlate().getBytes())) + "/invoices",
                    APIURI + "persons/" + vehicle.getOwner().getId(),
                    vehicle.getCarTrackerId().toString());
            vehicleDTOs.add(vehicleDTO);
        }
        return vehicleDTOs;
    }

    public static VehicleDTO VEHICLESTODTOS(Vehicle vehicle) {
        if (vehicle == null) {
            return new VehicleDTO();
        }

        VehicleDTO vehicleDTO = new VehicleDTO(
                vehicle.getHashedLicencePlate(),
                APIURI + "vehicles/" + new String(Base64.getEncoder().encode(vehicle.getHashedLicencePlate().getBytes())) + "/journeys",
                APIURI + "vehicles/" + new String(Base64.getEncoder().encode(vehicle.getHashedLicencePlate().getBytes())) + "/invoices",
                APIURI + "persons/" + vehicle.getOwner().getId(),
                vehicle.getCarTrackerId().toString());

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
                    s.getPrice() + "",
                    APIURI + "persons/" + s.getVehicle().getOwner().getId(),
                    s.getVehicle().getCarTrackerId());
            subInvoiceDTOs.add(invoice);
        }
        return subInvoiceDTOs;
    }

    public static SubInvoiceDTO SUBINVOICESTODTOS(SubInvoice subInvoice) {
        if (subInvoice == null) {
            return new SubInvoiceDTO();
        }

        SubInvoiceDTO subInvoiceDTO = new SubInvoiceDTO(subInvoice.getInvoiceNumber(),
                subInvoice.getCountry(),
                subInvoice.getPaymentStatus(),
                subInvoice.getInvoiceDate(),
                subInvoice.getPrice() + "",
                APIURI + "persons/" + subInvoice.getVehicle().getOwner().getId(),
                subInvoice.getVehicle().getCarTrackerId());
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
                    APIURI + "translocations/journeyid/" + j.getId());
            journeyDTOs.add(journey);
        }
        return journeyDTOs;
    }

    public static JourneyDTO JOURNEYSTODTOS(Journey journey) {
        if (journey == null) {
            return new JourneyDTO();
        }

        JourneyDTO journeyDTO = new JourneyDTO(journey.getId(),
                APIURI + "translocations/journeyid/" + journey.getId());
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
                    t.getCarTrackerId(),
                    t.getCountryCode());
            transLocationDTOs.add(transLocation);
        }
        return transLocationDTOs;
    }

    public static TransLocationDTO TRANSLOCATIONSTODTOS(TransLocation location) {
        if (location == null) {
            return new TransLocationDTO();
        }

        TransLocationDTO transLocationDTO = new TransLocationDTO(
                location.getLat(),
                location.getLon(),
                location.getDateTime(),
                location.getCarTrackerId(),
                location.getCountryCode());
        return transLocationDTO;
    }

    public static List<RoadDTO> ROADSTODTOS(List<Road> roads) {
        List<RoadDTO> roadDtos = new ArrayList<>();
        if (roads == null || roads.isEmpty()) {
            return roadDtos;
        }

        for (Road r : roads) {
            RoadDTO roadDto = new RoadDTO(
                    r.getId(),
                    r.getShortName(),
                    r.getLongName(),
                    r.getRate());
            roadDtos.add(roadDto);
        }
        return roadDtos;
    }

    public static RoadDTO ROADSTODTOS(Road road) {
        if (road == null) {
            return new RoadDTO();
        }

        return new RoadDTO(
                road.getId(),
                road.getShortName(),
                road.getLongName(),
                road.getRate());
    }

    public static List<PersonDTO> PERSONSTODTOS(List<Person> persons) {
        List<PersonDTO> personDtos = new ArrayList<>();
        if (persons == null || persons.isEmpty()) {
            return personDtos;
        }

        for (Person p : persons) {
            PersonDTO personDto = new PersonDTO(
                    p.getId(),
                    p.getFirstName(),
                    p.getLastName(),
                    APIURI + "persons/" + p.getId() + "/vehicles",
                    APIURI + "address/" + p.getId());
            personDtos.add(personDto);
        }
        return personDtos;
    }

    public static PersonDTO PERSONSTODTOS(Person person) {
        if (person == null) {
            return new PersonDTO();
        }

        return new PersonDTO(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                APIURI + "persons/" + person.getId() + "/vehicles",
                APIURI + "address/" + person.getId()
        );
    }

    public static List<AddressDTO> ADDRESSTODTOS(List<Address> addresses) {
        List<AddressDTO> addressDtos = new ArrayList<>();
        if (addresses == null || addresses.isEmpty()) {
            return addressDtos;
        }

        for (Address a : addresses) {
            AddressDTO addressDTO = new AddressDTO(
                    a.getId(),
                    a.getStreetName(),
                    a.getStreetNumber(),
                    a.getZipCode(),
                    a.getCity(),
                    a.getCountry());

            addressDtos.add(addressDTO);
        }
        return addressDtos;
    }

    public static AddressDTO ADDRESSTODTOS(Address address) {
        if (address == null) {
            return new AddressDTO();
        }

        return new AddressDTO(
                address.getId(),
                address.getStreetName(),
                address.getStreetNumber(),
                address.getZipCode(),
                address.getCity(),
                address.getCountry());
    }
}
