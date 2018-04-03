package rest;

import domain.Journey;
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
import service.JourneyService;

/**
 *
 * @author Teun
 */
@Stateless
@Path("journeys")
public class JourneyResource {

    @Inject
    JourneyService journeyService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertJourney(Journey journey) {
        journeyService.insertJourney(journey);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateJourney(Journey journey) {
        journeyService.updateJourney(journey);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void removeJourney(Journey journey) {
        journeyService.removeJourney(journey);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Journey getJourney(@PathParam("id") String id) {
        return journeyService.getJourney(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Journey> getAllJourneys() {
        return journeyService.getAllJourneys();
    }
}
