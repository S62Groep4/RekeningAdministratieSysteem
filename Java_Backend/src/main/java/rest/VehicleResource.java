package rest;

import domain.Vehicle;
import dto.JourneyDTO;
import dto.SubInvoiceDTO;
import dto.VehicleDTO;
import java.util.Base64;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
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
    @Path("{LicensePlate}")
    public Response getVehicle(
            @DefaultValue("true") @QueryParam("hashed") boolean hashed,
            @PathParam("LicensePlate") String licensePlate) {
        if (hashed) {
            String hashedLicensePlate = new String(Base64.getDecoder().decode(licensePlate));
            VehicleDTO dto = DomainToDto.VEHICLESTODTOS(vehicleService.getVehicle(hashedLicensePlate, true));
            return Response.ok(dto).build();
        } else {
            VehicleDTO dto = DomainToDto.VEHICLESTODTOS(vehicleService.getVehicle(licensePlate, false));
            return Response.ok(dto).build();
        }
    }

    @GET
    @Path("cartracker/{carTrackerId}")
    public Response getVehicle(@PathParam("carTrackerId") Long carTrackerId) {
        VehicleDTO dto = DomainToDto.VEHICLESTODTOS(vehicleService.getVehicle(carTrackerId));
        return Response.ok(dto).build();
    }

    @GET
    @Path("owner/{personId}")
    public Response getVehiclesOwnedBy(@PathParam("personId") Long personId) {
        List<VehicleDTO> dto = DomainToDto.VEHICLESTODTOS(vehicleService.getVehiclesOwnedBy(personId));
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
