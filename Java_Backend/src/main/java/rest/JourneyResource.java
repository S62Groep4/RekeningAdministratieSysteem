package rest;

import domain.Journey;
import dto.JourneyDTO;
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
import service.JourneyService;
import util.DomainToDto;
import util.DtoToDomain;

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
    public Response insertJourney(JourneyDTO journey) {
        Journey journeyToInsert = DtoToDomain.JOURNEY_DTO_TO_DOMAIN(journey);
        JourneyDTO dto = DomainToDto.JOURNEYSTODTOS(journeyService.insertJourney(journeyToInsert));
        return Response.ok(dto).build();
    }

    @PUT
    public Response updateJourney(JourneyDTO journey) {
        Journey journeyToUpdate = DtoToDomain.JOURNEY_DTO_TO_DOMAIN(journey);
        JourneyDTO dto = DomainToDto.JOURNEYSTODTOS(journeyService.updateJourney(journeyToUpdate));
        return Response.ok(dto).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeJourney(@PathParam("id") int id) {
        journeyService.removeJourney(new Long(id));
        return Response.ok().build();
    }

    @GET
    @Path("{id}")
    public Response getJourney(@PathParam("id") int id) {
        JourneyDTO dto = DomainToDto.JOURNEYSTODTOS(journeyService.getJourney(new Long(id)));
        return Response.ok(dto).build();
    }

    @GET
    public Response getAllJourneys() {
        List<JourneyDTO> dto = DomainToDto.JOURNEYSTODTOS(journeyService.getAllJourneys());
        return Response.ok(dto).build();
    }
}
