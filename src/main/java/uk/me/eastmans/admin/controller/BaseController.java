package uk.me.eastmans.admin.controller;

import uk.me.eastmans.admin.service.UserMessageService;
import uk.me.eastmans.admin.view.HtmlProducer;
import uk.me.eastmans.admin.view.LoggedInUserPrincipal;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by markeastman on 21/10/2016.
 */
public class BaseController {
    @Inject
    private HtmlProducer uiProducer;

    @Inject
    private UserMessageService userMessageService;

    private @Context
    HttpServletRequest request;

    private @Context
    HttpServletResponse response;

    private @Context
    SecurityContext securityContext;

    protected String processUI(String templateName) throws IOException
    {
        // Need to always have a model
        Map model = new HashMap();
        return processUI( templateName, model);
    }

    protected String processUI(String templateName, Map model) throws IOException
    {
        // Need to process some common attributes for all screens
        System.out.println("request = " + request);
        preProcessUI(model);
        return uiProducer.process( request, response, templateName, model);
    }

    protected UserMessageService getUserMessageService()
    {
        return userMessageService;
    }

    private void preProcessUI( Map model )
    {
        // Get the logged in user
        Principal user = securityContext.getUserPrincipal();
        if (user instanceof LoggedInUserPrincipal) {
            LoggedInUserPrincipal principal = (LoggedInUserPrincipal) user;
            List messages = userMessageService.getMessagesForUser(principal.getId());
            model.put("userMessages", messages);
        }
        // Put out the user name of we are logged in
        Principal principal = securityContext.getUserPrincipal();
        if (principal != null)
            model.put( "username", principal.getName() );
    }
}
