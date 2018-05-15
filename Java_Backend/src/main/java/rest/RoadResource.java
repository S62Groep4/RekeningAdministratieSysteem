package rest;

import domain.Road;
import dto.RoadDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.RoadService;
import util.DomainToDto;
import util.DtoToDomain;

/**
 *
 * @author Teun
 */
@Stateless
@Path("roads")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RoadResource {

    @Inject
    RoadService roadService;

    @POST
    public Response insertRoad(RoadDTO road) {
        Road roadToInsert = DtoToDomain.ROAD_DTO_TO_DOMAIN(road);
        RoadDTO dto = DomainToDto.ROADSTODTOS(roadService.insertRoad(roadToInsert));
        return Response.ok(dto).build();
    }

    @PUT
    public Response updateRoad(RoadDTO road) {
        Road roadToInsert = DtoToDomain.ROAD_DTO_TO_DOMAIN(road);
        RoadDTO dto = DomainToDto.ROADSTODTOS(roadService.updateRoad(roadToInsert));
        return Response.ok(dto).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeRoad(@PathParam("id") int id) {
        roadService.removeRoad(new Long(id));
        return Response.ok().build();
    }

    @GET
    @Path("{query}")
    public Response getRoad(
            @PathParam("query") String query,
            @DefaultValue("name") @QueryParam("searchtype") String searchtype) {
        if (searchtype.equals("id")) {
            RoadDTO dto = DomainToDto.ROADSTODTOS(roadService.getRoad(new Long(query)));
            return Response.ok(dto).build();
        } else {
            List<RoadDTO> dtos = DomainToDto.ROADSTODTOS(roadService.searchRoad(query));
            return Response.ok(dtos).build();
        }
    }

    @GET
    public Response getAllRoads() {
        List<RoadDTO> dto = DomainToDto.ROADSTODTOS(roadService.getAllRoads());
        return Response.ok(dto).build();
    }
}
