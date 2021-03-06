package rest;

import domain.Person;
import domain.Vehicle;
import dto.AddressDTO;
import dto.PersonDTO;
import dto.VehicleDTO;
import service.AddressService;
import service.PersonService;
import service.VehicleService;
import util.DomainToDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import util.DtoToDomain;

@Stateless
@Path("persons")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonService personService;

    @Inject
    VehicleService vehicleService;

    @Inject
    AddressService addressService;

    @GET
    public Response getPersons() {
        List<PersonDTO> dto = DomainToDto.PERSONSTODTOS(personService.getAllPersons());
        return Response.ok(dto).build();
    }

    @PUT
    public Response updatePerson(PersonDTO person) {
        PersonDTO dto = DomainToDto.PERSONSTODTOS(personService.updatePerson(DtoToDomain.PERSON_DTO_TO_DOMAIN(person)));
        return Response.ok(dto).build();
    }

    @GET
    @Path("{identifier}/vehicles")
    public Response getPersonVehicle(
            @PathParam("identifier") int id) {
        List<VehicleDTO> vehicleDTOS = DomainToDto.VEHICLESTODTOS(personService.getPerson(id).getVehicles());
        return Response.ok(vehicleDTOS).build();
    }

    @GET
    @Path("/email={identifier}/vehicles")
    public Response getPersonVehicleByEmail(
            @PathParam("identifier") String accountEmail) {
        List<VehicleDTO> vehicleDTOS = DomainToDto.VEHICLESTODTOS(personService.getPersonAndFetchVehiclesEagerly(accountEmail).getVehicles());
        return Response.ok(vehicleDTOS).build();
    }

    @PUT
    @Path("{identifier}/vehicles/{vehicleId}")
    public Response updatePersonVehicle(
            @PathParam("identifier") int id,
            @PathParam("vehicleId") String vehicleId) {
        Vehicle vehicle = null;
        if (vehicleId.length() > 15) {
            vehicle = vehicleService.getVehicle(vehicleId, true);
        } else {
            vehicle = vehicleService.getVehicle(vehicleId, false);
        }
        Person person = personService.getPerson(id);
        person.addVehicle(vehicle);
        PersonDTO dto = DomainToDto.PERSONSTODTOS(personService.updatePerson(person));
        return Response.ok(dto).build();
    }

    @DELETE
    @Path("{identifier}/vehicles/{vehicleId}")
    public Response deletePersonVehicle(
            @PathParam("identifier") int id,
            @PathParam("vehicleId") String vehicleId) {
        Vehicle vehicle = null;
        if (vehicleId.length() > 15) {
            vehicle = vehicleService.getVehicle(vehicleId, true);
        } else {
            vehicle = vehicleService.getVehicle(vehicleId, false);
        }

        Person person = personService.getPerson(id);
        person.removeVehicle(vehicle);
        PersonDTO dto = DomainToDto.PERSONSTODTOS(personService.updatePerson(person));
        return Response.ok(dto).build();
    }

    @GET
    @Path("{identifier}")
    public Response getPerson(
            @DefaultValue("id") @QueryParam("type") String identifierType,
            @PathParam("identifier") String identifier) {
        switch (identifierType) {
            case "id": {
                PersonDTO personDTO = DomainToDto.PERSONSTODTOS(personService.getPerson(new Long(identifier)));
                return Response.ok(personDTO).build();
            }
            case "plainplate": {
                PersonDTO personDTO = DomainToDto.PERSONSTODTOS(personService.getPerson(new Long(identifier)));
                return Response.ok(personDTO).build();
            }
            case "hashedplate": {
                PersonDTO personDTO = DomainToDto.PERSONSTODTOS(personService.getPerson(new Long(identifier)));
                return Response.ok(personDTO).build();
            }
            default:
                break;
        }
        return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), "Invalid type! [ null / id / plainplate / hashedplate]").build();
    }

    @GET
    @Path("licenceplate/{licenceplate}")
    public Response getPersonByLicenceplate(@PathParam("licenceplate") String licenceplate) {
        PersonDTO personDTO = DomainToDto.PERSONSTODTOS(personService.getPersonByLicensePlate(licenceplate, true));
        return Response.ok(personDTO).build();
    }

    @POST
    public Response insertPerson(PersonDTO person) {
        PersonDTO personDTO = DomainToDto.PERSONSTODTOS(personService.insertPerson(DtoToDomain.PERSON_DTO_TO_DOMAIN(person)));
        return Response.ok(personDTO).build();
    }

    @POST
    @Path("{identifier}/address")

    public Response insertAddress(
            @PathParam("identifier") int id,
            AddressDTO addressDTO) {
        // Link the address create an address object and link this to a person
        Person person = personService.setPersonsAddress(id, DtoToDomain.ADDRESS_DTO_TO_DOMAIN(addressDTO));
        // Return a dto of the address
        AddressDTO dto = DomainToDto.ADDRESSTODTOS(person.getAddress());
        return Response.ok(dto).build();
    }
}
