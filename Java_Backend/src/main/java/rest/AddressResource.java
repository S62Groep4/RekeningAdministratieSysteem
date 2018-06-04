package rest;

import domain.Address;
import domain.Person;
import domain.Vehicle;
import dto.AddressDTO;
import dto.PersonDTO;
import dto.VehicleDTO;
import service.AddressService;
import service.PersonService;
import service.VehicleService;
import util.DomainToDto;
import util.DtoToDomain;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("address")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AddressResource {

    @Inject
    AddressService addressService;

    @GET
    public Response getAddresses() {
        List<AddressDTO> dto = DomainToDto.ADDRESSTODTOS(addressService.getAllAddresses());
        return Response.ok(dto).build();
    }

    @PUT
    public Response updateAddress(AddressDTO person) {
        AddressDTO dto = DomainToDto.ADDRESSTODTOS(addressService.updateAddress(DtoToDomain.ADDRESS_DTO_TO_DOMAIN(person)));
        return Response.ok(dto).build();
    }

    @GET
    @Path("{identifier}")
    public Response getAddress(
            @PathParam("identifier") int id) {
        AddressDTO addressDTO = DomainToDto.ADDRESSTODTOS(addressService.getAddress(id));
        return Response.ok(addressDTO).build();
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
            @PathParam("identifier") int identifier) {
        if (identifierType.equals("id")) {
            PersonDTO personDTO = DomainToDto.PERSONSTODTOS(personService.getPerson(new Long(identifier)));
            return Response.ok(personDTO).build();
        } else if (identifierType.equals("plainplate")) {
            PersonDTO personDTO = DomainToDto.PERSONSTODTOS(personService.getPerson(new Long(identifier)));
            return Response.ok(personDTO).build();
        } else if (identifierType.equals("hashedplate")) {
            PersonDTO personDTO = DomainToDto.PERSONSTODTOS(personService.getPerson(new Long(identifier)));
            return Response.ok(personDTO).build();
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
}
