package rest;

import domain.SubInvoice;
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
import service.SubInvoiceService;

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
    public void insertTransLocation(SubInvoice invoice) {
        subInvoiceService.insertSubInvoice(invoice);
    }

    @PUT
    public void updateJourney(SubInvoice invoice) {
        subInvoiceService.updateSubInvoice(invoice);
    }

    @DELETE
    @Path("{invoiceNumber}")
    public void removeJourney(@PathParam("invoiceNumber") String invoiceNumber) {
        subInvoiceService.removeSubInvoice(invoiceNumber);
    }

    @GET
    @Path("{invoiceNumber}")
    public SubInvoice getJourney(@PathParam("invoiceNumber") String invoiceNumber) {
        return subInvoiceService.getSubInvoice(invoiceNumber);
    }

    @GET
    public List<SubInvoice> getAllTransLocations() {
        return subInvoiceService.getAllSubInvoices();
    }
}
