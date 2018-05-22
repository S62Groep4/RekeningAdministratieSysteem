package rest;

import domain.Person;
import domain.Vehicle;
import dto.JourneyDTO;
import dto.PersonDTO;
import dto.SubInvoiceDTO;
import dto.VehicleDTO;
import service.PersonService;
import service.VehicleService;
import util.DomainToDto;
import util.DtoToDomain;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Path("persons")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonService personService;

    @Inject
    VehicleService vehicleService;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersons() {
        List<Person> persons = personService.getAllPersons();
        List<PersonDTO> personDTOS = new ArrayList<>();
        for (Person person : persons) {
            personDTOS.add(new PersonDTO(person.getId(), person.getFirstName(), person.getLastName()));
        }
        return Response.ok(personDTOS).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePerson(PersonDTO person) {
        personService.updatePerson(new Person(person.getId(), person.getFirstName(), person.getLastName()));
        return Response.ok().build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{identifier}/vehicles")
    public Response getPersonVehicle(
            @PathParam("identifier") int id) {
        Person person = personService.getPerson(id);
        List<VehicleDTO> vehicleDTOS = new ArrayList<>();
        for (Vehicle vehicle : person.getVehicles()) {
            System.out.println("Collecting a vehicle from person: " + person.getFirstName() + " with ID: " + person.getId());
            System.out.println("Collecting vehicle licence: " + vehicle.getLicencePlate() + " and hashedlicence: " + vehicle.getHashedLicencePlate());
            vehicleDTOS.add(DomainToDto.VEHICLESTODTOS(vehicle));
        }
        System.out.println("List size: " + vehicleDTOS.size());
        for (int i = 0; i < vehicleDTOS.size(); i++) {
            System.out.println("List content: " + vehicleDTOS.get(i).getHashedLicensePlate());
        }
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
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
        personService.updatePerson(person);
        return Response.ok().build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{identifier}/vehicles/{vehicleId}")
    public Response deletePersonVehicle(
            @PathParam("identifier") int id,
            @PathParam("vehicleId") String vehicleId) {
        Person person = personService.getPerson(id);
        Vehicle vehicle = null;
        if (vehicleId.length() > 15) {
            vehicle = vehicleService.getVehicle(vehicleId, true);
        } else {
            vehicle = vehicleService.getVehicle(vehicleId, false);
        }

        person.removeVehicle(vehicle);
        personService.updatePerson(person);

        return Response.ok().build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{identifier}")
    public Response getPerson(
            @DefaultValue("id") @QueryParam("type") String identifierType,
            @PathParam("identifier") String identifier) {
        if (identifierType.equals("id")) {
            Person person = personService.getPerson(Integer.parseInt(identifier));
            PersonDTO personDTO = new PersonDTO(person.getId(), person.getFirstName(), person.getLastName());
            return Response.ok(personDTO).build();
        } else if (identifierType.equals("plainplate")) {
            Person person = personService.getPerson(Integer.parseInt(identifier));
            PersonDTO personDTO = new PersonDTO(person.getId(), person.getFirstName(), person.getLastName());
            return Response.ok(personDTO).build();
        } else if (identifierType.equals("hashedplate")) {
            Person person = personService.getPerson(Integer.parseInt(identifier));
            PersonDTO personDTO = new PersonDTO(person.getId(), person.getFirstName(), person.getLastName());
            return Response.ok(personDTO).build();
        }
        return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), "Invalid type! [ null / id / plainplate / hashedplate]").build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("licenceplate/{licenceplate}")
    public Response getPersonByLicenceplate(@PathParam("licenceplate") String licenceplate) {

        Person person = personService.getPersonByLicensePlate(licenceplate, false);
        PersonDTO personDTO = new PersonDTO(person.getId(), person.getFirstName(), person.getLastName());
        return Response.ok(personDTO).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPerson(PersonDTO person) {
        Person createPerson = new Person(person.getId(), person.getFirstName(), person.getLastName());
        createPerson = personService.createPerson(createPerson);
        return Response.ok(createPerson).build();
    }

}
