package rest;

import domain.Journey;
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
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class JourneyResource {

    @Inject
    JourneyService journeyService;

    @POST
    public void insertJourney(Journey journey) {
        journeyService.insertJourney(journey);
    }

    @PUT
    public void updateJourney(Journey journey) {
        journeyService.updateJourney(journey);
    }

    @DELETE
    @Path("{id}")
    public void removeJourney(@PathParam("id") String id) {
        journeyService.removeJourney(id);
    }

    @GET
    @Path("{id}")
    public Journey getJourney(@PathParam("id") String id) {
        return journeyService.getJourney(id);
    }

    @GET
    public List<Journey> getAllJourneys() {
        return journeyService.getAllJourneys();
    }
}
