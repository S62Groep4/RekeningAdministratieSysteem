package rest;

import domain.User;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;
import service.LoginService;

/**
 *
 * @author Teun
 */
@Path("login")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@Stateless
public class LoginResource {

    @Inject
    LoginService loginService;

    @POST
    public Response login(User user) {
//      for debugging        
//      System.out.println(user.getEmail());
        boolean valid = loginService.verifyLogin(user.getEmail(), user.getPassword());

        if (valid == true) {
            String token = loginService.returnToken(user.getEmail());
            return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).header("Access-Control-Expose-Headers", "Authorization").build();
        }

        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
