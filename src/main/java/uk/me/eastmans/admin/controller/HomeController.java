package uk.me.eastmans.admin.controller;

import uk.me.eastmans.admin.service.PersonService;
import uk.me.eastmans.admin.view.HtmlProducer;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by markeastman on 26/09/2016.
 */
@Path("home")
public class HomeController {
    @Inject
    private HtmlProducer uiProducer;

    @Inject
    private PersonService personService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String home(@Context HttpServletRequest request, @Context HttpServletResponse response )
            throws IOException {

        checkDatabase();

        Map model = new HashMap();
        model.put( "username", "Mark Eastman" );
        return uiProducer.process(request,response, "home", model);
    }

    public void checkDatabase()
    {
        // Try out persistence
        personService.test();
    }
}
