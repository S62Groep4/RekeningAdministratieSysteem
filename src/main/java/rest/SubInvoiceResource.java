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
@Path("subinvoice")
public class SubInvoiceResource {

    @Inject
    SubInvoiceService subInvoiceService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertTransLocation(SubInvoice invoice) {
        subInvoiceService.insertSubInvoice(invoice);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateJourney(SubInvoice invoice) {
        subInvoiceService.updateSubInvoice(invoice);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void removeJourney(SubInvoice invoice) {
        subInvoiceService.removeSubInvoice(invoice);
    }

    @GET
    @Path("{invoiceNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public SubInvoice getJourney(@PathParam("invoiceNumber") String invoiceNumber) {
        return subInvoiceService.getSubInvoice(invoiceNumber);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SubInvoice> getAllTransLocations() {
        return subInvoiceService.getAllSubInvoices();
    }
}
