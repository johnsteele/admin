package uk.me.eastmans.admin.controller;

import uk.me.eastmans.admin.service.PersonService;
import uk.me.eastmans.admin.view.HtmlProducer;
import uk.me.eastmans.admin.view.SecurityFilter;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by markeastman on 26/09/2016.
 */
@Path("login")
public class LoginController extends HttpServlet {
    @Inject
    private HtmlProducer uiProducer;

    @Inject
    private PersonService personService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    @PermitAll
    public String login(@Context HttpServletRequest request, @Context HttpServletResponse response)
            throws IOException {

        return uiProducer.process(request, response, "login");
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String loginAttempt(@FormParam("username") String user, @FormParam("password") String password,
                               @Context HttpServletRequest request, @Context HttpServletResponse response)
            throws IOException {

        System.out.println("User and password " + user + "," + password);

        if ("admin".equals(user) && "admin".equals(password)) {
            // All ok
            HttpSession session = request.getSession();
            session.setAttribute(SecurityFilter.USER_KEY, user);
            response.sendRedirect("home");
            return null;
        } else {
            Map errors = new HashMap();
            errors.put("authenticationError", "invalid user or password");
            return uiProducer.process(request, response, "login", errors);
        }
    }
}
