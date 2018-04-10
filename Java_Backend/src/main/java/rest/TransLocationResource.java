package rest;

import domain.TransLocation;
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
import service.TransLocationService;

/**
 *
 * @author Teun
 */
@Stateless
@Path("translocations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransLocationResource {

    @Inject
    TransLocationService transLocationService;

    @POST
    public void insertTransLocation(TransLocation location) {
        transLocationService.insertTransLocation(location);
    }

    @PUT
    public void updateJourney(TransLocation location) {
        transLocationService.updateTransLocation(location);
    }

    @DELETE
    @Path("{serialNumber}")
    public void removeJourney(@PathParam("serialNumber") String serialNumber) {
        transLocationService.removeTransLocation(serialNumber);
    }

    @GET
    @Path("{serialNumber}")
    public TransLocation getJourney(@PathParam("serialNumber") String serialNumber) {
        return transLocationService.getTransLocation(serialNumber);
    }

    @GET
    public List<TransLocation> getAllTransLocations() {
        return transLocationService.getAllTransLocations();
    }
}
