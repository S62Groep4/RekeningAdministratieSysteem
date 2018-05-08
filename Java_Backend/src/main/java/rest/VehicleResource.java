package rest;

import domain.Vehicle;
import dto.JourneyDTO;
import dto.SubInvoiceDTO;
import dto.VehicleDTO;
import java.util.Base64;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.VehicleService;
import util.DomainToDto;
import util.DtoToDomain;

@Stateless
@Path("vehicles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VehicleResource {

    @Inject
    VehicleService vehicleService;

    @POST
    public Response insertVehicle(VehicleDTO vehicle) {
        Vehicle vehicleToÍnsert = DtoToDomain.VEHICLE_DTO_TO_DOMAIN(vehicle);
        VehicleDTO dto = DomainToDto.VEHICLESTODTOS(vehicleService.insertVehicle(vehicleToÍnsert));
        return Response.ok(dto).build();
    }

    @PUT
    public Response updateVehicle(VehicleDTO vehicle) {
        Vehicle vehicleToUpdate = DtoToDomain.VEHICLE_DTO_TO_DOMAIN(vehicle);
        VehicleDTO dto = DomainToDto.VEHICLESTODTOS(vehicleService.updateVehicle(vehicleToUpdate));
        return Response.ok(dto).build();
    }

    @DELETE
    @Path("{hashedLicensePlate}")
    public Response removeVehicle(@PathParam("hashedLicensePlate") String encodedLicensePlate) {
        String hashedLicensePlate = new String(Base64.getDecoder().decode(encodedLicensePlate));
        vehicleService.removeVehicle(hashedLicensePlate);
        return Response.ok().build();
    }

    @GET
    @Path("{hashedLicensePlate}")
    public Response getVehicle(@PathParam("hashedLicensePlate") String encodedLicensePlate) {
        String hashedLicensePlate = new String(Base64.getDecoder().decode(encodedLicensePlate));
        VehicleDTO dto = DomainToDto.VEHICLESTODTOS(vehicleService.getVehicle(hashedLicensePlate));
        return Response.ok(dto).build();
    }

    @GET
    @Path("{hashedLicensePlate}/journeys")
    public Response getVehicleJourneys(@PathParam("hashedLicensePlate") String encodedLicensePlate) {
        String hashedLicensePlate = new String(Base64.getDecoder().decode(encodedLicensePlate));
        List<JourneyDTO> dto = DomainToDto.JOURNEYSTODTOS(vehicleService.getVehicleJourneys(hashedLicensePlate));
        return Response.ok(dto).build();
    }

    @GET
    @Path("{hashedLicensePlate}/invoices")
    public Response getVehicleInvoices(@PathParam("hashedLicensePlate") String encodedLicensePlate) {
        String hashedLicensePlate = new String(Base64.getDecoder().decode(encodedLicensePlate));
        List<SubInvoiceDTO> dto = DomainToDto.SUBINVOICESTODTOS(vehicleService.getVehicleInvoices(hashedLicensePlate));
        return Response.ok(dto).build();
    }

    @GET
    public Response getAllVehicles() {
        List<VehicleDTO> dto = DomainToDto.VEHICLESTODTOS(vehicleService.getAllVehicles());
        return Response.ok(dto).build();
    }
}
