package uk.me.eastmans.admin.controller;

import uk.me.eastmans.admin.model.User;
import uk.me.eastmans.admin.service.UserService;
import uk.me.eastmans.admin.view.LoggedInUserPrincipal;
import uk.me.eastmans.admin.view.SecurityFilter;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
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
public class LoginController extends BaseController  {

    @Inject
    private UserService userService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    @PermitAll
    public String login()
            throws IOException {

        return processUI("login");
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String loginAttempt(@NotNull @FormParam("username") String name, @NotNull @FormParam("password") String password,
                               @Context HttpServletRequest request, @Context HttpServletResponse response)
            throws IOException {

        User user = userService.getUserWithLogin(name,password);
        if (user != null) {
            // All ok
            HttpSession session = request.getSession();
            // Should lookup user really
            session.setAttribute(SecurityFilter.USER_KEY, new LoggedInUserPrincipal(user));
            response.sendRedirect("home");
            return null;
        } else {
            Map errors = new HashMap();
            errors.put("authenticationError", "invalid user or password");
            return processUI("login", errors);
        }
    }
}