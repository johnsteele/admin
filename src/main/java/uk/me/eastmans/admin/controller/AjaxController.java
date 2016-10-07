package uk.me.eastmans.admin.controller;

import uk.me.eastmans.admin.service.UserMessageService;
import uk.me.eastmans.admin.view.HtmlProducer;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
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
@Path("/")
public class AjaxController {
    @Inject
    private HtmlProducer uiProducer;

    @Inject
    private UserMessageService  userMessageService;

    @POST
    @Path("clearMessages/{maxId}")
    @RolesAllowed("ADMIN")
    public void home(@PathParam("maxId") Long maxId,
                     @Context HttpServletRequest request, @Context HttpServletResponse response,
                     @Context SecurityContext securityContext)
            throws IOException {

        userMessageService.clearMessages( 1L, maxId );
    }
}
