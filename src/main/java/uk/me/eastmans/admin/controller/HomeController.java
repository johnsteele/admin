package uk.me.eastmans.admin.controller;

import uk.me.eastmans.admin.service.UserMessageService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by markeastman on 26/09/2016.
 */
@Path("home")
public class HomeController extends BaseController {
    @Inject
    private UserMessageService  userMessageService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    @RolesAllowed("ADMIN")
    public String home()
            throws IOException {

        return processUI("home");
    }
}
