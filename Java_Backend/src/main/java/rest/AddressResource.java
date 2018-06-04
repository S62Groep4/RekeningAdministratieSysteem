package rest;

import domain.Address;
import domain.Person;
import domain.Vehicle;
import dto.AddressDTO;
import dto.PersonDTO;
import dto.VehicleDTO;
import service.AddressService;
import service.PersonService;
import service.VehicleService;
import util.DomainToDto;
import util.DtoToDomain;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("address")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AddressResource {

    @Inject
    AddressService addressService;

    @GET
    public Response getAddresses() {
        List<AddressDTO> dto = DomainToDto.ADDRESSTODTOS(addressService.getAllAddresses());
        return Response.ok(dto).build();
    }

    @PUT
    public Response updateAddress(AddressDTO addressDTO) {
        AddressDTO dto = DomainToDto.ADDRESSTODTOS(addressService.updateAddress(DtoToDomain.ADDRESS_DTO_TO_DOMAIN(addressDTO)));
        return Response.ok(dto).build();
    }

    @GET
    @Path("{identifier}")
    public Response getAddress(
            @PathParam("identifier") int id) {
        AddressDTO addressDTO = DomainToDto.ADDRESSTODTOS(addressService.getAddress(id));
        return Response.ok(addressDTO).build();
    }

}
