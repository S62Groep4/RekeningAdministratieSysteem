package rest;

import domain.TransLocation;
import dto.TransLocationDTO;
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
import service.TransLocationService;
import util.DomainToDto;
import util.DtoToDomain;

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
    public Response insertTransLocation(TransLocationDTO location) {
        TransLocation locationToInsert = DtoToDomain.TRANSLOCATION_DTO_TO_DOMAIN(location);
        TransLocationDTO dto = DomainToDto.TRANSLOCATIONSTODTOS(transLocationService.insertTransLocation(locationToInsert));
        return Response.ok(dto).build();
    }

    @PUT
    public Response updateTransLocation(TransLocationDTO location) {
        TransLocation locationToUpdate = DtoToDomain.TRANSLOCATION_DTO_TO_DOMAIN(location);
        TransLocationDTO dto = DomainToDto.TRANSLOCATIONSTODTOS(transLocationService.updateTransLocation(locationToUpdate));
        return Response.ok(dto).build();
    }

    @DELETE
    @Path("{carTrackerId}")
    public Response removeTransLocation(@PathParam("carTrackerId") Long carTrackerId) {
        transLocationService.removeTransLocation(carTrackerId);
        return Response.ok().build();
    }

    @GET
    @Path("{carTrackerId}")
    public Response getTransLocation(@PathParam("carTrackerId") Long carTrackerId) {
        TransLocationDTO dto = DomainToDto.TRANSLOCATIONSTODTOS(transLocationService.getTransLocation(carTrackerId));
        return Response.ok(dto).build();
    }

    @GET
    @Path("journeyid/{journeyId}")
    public Response getAllTransLocationsByJourney(@PathParam("journeyId") long id) {
        List<TransLocationDTO> dto = DomainToDto.TRANSLOCATIONSTODTOS(transLocationService.getAllTransLocationsByJourney(id));
        return Response.ok(dto).build();
    }

    @GET
    public Response getAllTransLocations() {
        List<TransLocationDTO> dto = DomainToDto.TRANSLOCATIONSTODTOS(transLocationService.getAllTransLocations());
        return Response.ok(dto).build();
    }
}
