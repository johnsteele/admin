package uk.me.eastmans.admin.controller;

import uk.me.eastmans.admin.service.PersonService;
import uk.me.eastmans.admin.service.UserMessageService;
import uk.me.eastmans.admin.view.HtmlProducer;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by markeastman on 26/09/2016.
 */
@Path("home")
public class HomeController {
    @Inject
    private HtmlProducer uiProducer;

    @Inject
    private UserMessageService  userMessageService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    @RolesAllowed("ADMIN")
    public String home(@Context HttpServletRequest request, @Context HttpServletResponse response,
                       @Context SecurityContext securityContext)
            throws IOException {

        System.out.println( "++++ Is user in role " + securityContext.isUserInRole("ADMIN"));

        Map model = new HashMap();
        // Get the message for the logged in user
        List messages = userMessageService.getMessagesForUser( 1L );
        model.put( "userMessages", messages );

        return uiProducer.process(request,response, "home", model);
    }
}
