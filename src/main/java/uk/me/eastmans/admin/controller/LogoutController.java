package uk.me.eastmans.admin.controller;

import uk.me.eastmans.admin.view.SecurityFilter;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by markeastman on 26/09/2016.
 */
@Path("logout")
public class LogoutController  {
    @GET
    @Produces(MediaType.TEXT_HTML)
    @PermitAll
    public void logout(@Context HttpServletRequest request, @Context HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute(SecurityFilter.USER_KEY, null);
        response.sendRedirect("login");
    }

}
