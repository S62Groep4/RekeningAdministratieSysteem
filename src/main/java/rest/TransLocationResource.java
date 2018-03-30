package rest;

import domain.Journey;
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
@Path("translocation")
public class TransLocationResource {

    @Inject
    TransLocationService transLocationService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertTransLocation(TransLocation location) {
        transLocationService.insertTransLocation(location);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateJourney(TransLocation location) {
        transLocationService.updateTransLocation(location);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void removeJourney(TransLocation location) {
        transLocationService.removeTransLocation(location);
    }

    @GET
    @Path("{serialnr}")
    @Produces(MediaType.APPLICATION_JSON)
    public TransLocation getJourney(@PathParam("serialnr") String serialNumber) {
        return transLocationService.getTransLocation(serialNumber);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TransLocation> getAllTransLocations() {
        return transLocationService.getAllTransLocations();
    }
}
