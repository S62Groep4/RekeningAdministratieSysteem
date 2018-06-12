package rest;

import domain.Journey;
import domain.SubInvoice;
import dto.JourneyDTO;
import dto.SubInvoiceDTO;
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
import service.SubInvoiceService;
import util.DomainToDto;
import util.DtoToDomain;

/**
 *
 * @author Teun
 */
@Stateless
@Path("subinvoices")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SubInvoiceResource {

    @Inject
    SubInvoiceService subInvoiceService;

    @POST
    public Response insertSubInvoice(SubInvoiceDTO invoice) {
        SubInvoice invoiceToInsert = DtoToDomain.SUBINVOICE_DTO_TO_DOMAIN(invoice);
        SubInvoiceDTO dto = DomainToDto.SUBINVOICESTODTOS(subInvoiceService.insertSubInvoice(invoiceToInsert));
        return Response.ok(dto).build();
    }

    @PUT
    public Response updateSubInvoice(SubInvoiceDTO invoice) {
        SubInvoice invoiceToUpdate = DtoToDomain.SUBINVOICE_DTO_TO_DOMAIN(invoice);
        SubInvoiceDTO dto = DomainToDto.SUBINVOICESTODTOS(subInvoiceService.updateSubInvoice(invoiceToUpdate));
        return Response.ok(dto).build();
    }

    @DELETE
    @Path("{invoiceNumber}")
    public Response removeSubInvoice(@PathParam("invoiceNumber") Long invoiceNumber) {
        subInvoiceService.removeSubInvoice(invoiceNumber);
        return Response.ok().build();
    }

    @GET
    @Path("{invoiceNumber}")
    public Response getSubInvoice(@PathParam("invoiceNumber") Long invoiceNumber) {
        SubInvoiceDTO dto = DomainToDto.SUBINVOICESTODTOS(subInvoiceService.getSubInvoice(invoiceNumber));
        return Response.ok(dto).build();
    }

    @GET
    public Response getAllSubInvoices() {
        List<SubInvoiceDTO> dto = DomainToDto.SUBINVOICESTODTOS(subInvoiceService.getAllSubInvoices());
        return Response.ok(dto).build();
    }

    @GET
    @Path("generate")
    public Response generateSubInvoices() {
        subInvoiceService.generateSubInvoices();
        return Response.ok().build();
    }
    
    @GET
    @Path("{invoiceNumber}/journeys")
    public Response getSubInvoiceJourneys(@PathParam("invoiceNumber") Long invoiceNumber) {
        List<Journey> journeys = subInvoiceService.getSubInvoiceJourneys(invoiceNumber);
        List<JourneyDTO> journeyDTOs = DomainToDto.JOURNEYSTODTOS(journeys);
        return Response.ok(journeyDTOs).build();
    }
}
