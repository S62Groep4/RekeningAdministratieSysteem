package rest;

import domain.Journey;
import domain.SubInvoice;
import domain.Vehicle;
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
import service.VehicleService;

@Stateless
@Path("vehicles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VehicleResource {

    @Inject
    VehicleService vehicleService;

    @POST
    public Vehicle insertVehicle(Vehicle vehicle) {
        return vehicleService.insertVehicle(vehicle);
    }

    @PUT
    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleService.updateVehicle(vehicle);
    }

    @DELETE
    @Path("{hashedLicensePlate}")
    public void removeVehicle(@PathParam("hashLicensePlate") String hashedLicensePlate) {
        vehicleService.removeVehicle(hashedLicensePlate);
    }

    @GET
    @Path("{hashedLicensePlate}")
    public Vehicle getVehicle(@PathParam("hashLicensePlate") String hashedLicensePlate) {
        return vehicleService.getVehicle(hashedLicensePlate);
    }

    @GET
    @Path("{hashedLicensePlate}/journeys")
    public List<Journey> getVehicleJourneys(@PathParam("hashLicensePlate") String hashedLicensePlate) {
        return vehicleService.getVehicleJourneys(hashedLicensePlate);
    }

    @GET
    @Path("{hashedLicensePlate}/invoices")
    public List<SubInvoice> getVehicleInvoices(@PathParam("hashLicensePlate") String hashedLicensePlate) {
        return vehicleService.getVehicleInvoices(hashedLicensePlate);
    }

    @GET
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }
}
