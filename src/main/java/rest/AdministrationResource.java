package rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import service.AdministrationSerivce;

/**
 *
 * @author Teun
 */
@Stateless
@Path("administration")
public class AdministrationResource {

    @Inject
    AdministrationSerivce administrationService;

    public AdministrationResource() {
    }

}
