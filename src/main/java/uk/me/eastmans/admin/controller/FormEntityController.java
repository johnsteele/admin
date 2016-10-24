package uk.me.eastmans.admin.controller;

import uk.me.eastmans.admin.forms.FormEntityForm;
import uk.me.eastmans.admin.model.FormEntity;
import uk.me.eastmans.admin.service.UserMessageService;
import uk.me.eastmans.admin.view.HtmlProducer;
import uk.me.eastmans.admin.view.SecurityFilter;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * Created by markeastman on 26/09/2016.
 */
@Path("form")
public class FormEntityController extends BaseController {

    @Inject
    private UserMessageService userMessageService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    @PermitAll
    public String form()
            throws IOException {

        return processUI("form");
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    /*
    public String formCreate( @FormParam("moreThanOrEqual10") Integer moreThanOrEqual10,
                              @FormParam("lessThanOrEqual100") Integer lessThanOrEqual100,
                             @Context HttpServletRequest request, @Context HttpServletResponse response)
            throws IOException {

        System.out.println("We have form " + moreThanOrEqual10 + " " + lessThanOrEqual100 );

        Map model = new HashMap();
        List messages = userMessageService.getMessagesForUser( 1L );
        model.put( "userMessages", messages );
        model.put("authenticationError", "invalid user or password");
        return uiProducer.process(request, response, "form", model);
    }
    */
    /*
    public String formCreate( @BeanParam FormEntityForm formEntity,
                             @Context HttpServletRequest request, @Context HttpServletResponse response)
            throws IOException {

        System.out.println("We have form " + formEntity.moreThanOrEqual10 + " " + formEntity.lessThanOrEqual100 );

        Map model = new HashMap();
        List messages = userMessageService.getMessagesForUser( 1L );
        model.put( "userMessages", messages );
        model.put("authenticationError", "invalid user or password");
        return uiProducer.process(request, response, "form", model);
    } */
    public String formCreate( MultivaluedMap<String,Object> form
                              )
            throws IOException {
        // We want to handle errors and then also process the form if none exist

        // We can now handle the form parameters and validate them
        System.out.println("We have form " + form );
        form.forEach(new BiConsumer<String, List<Object>>() {
            @Override
            public void accept(String s, List<Object> objects) {
                System.out.println( "We have a name " + s + " with objects " + objects);
            }
        });

        Map model = new HashMap();
        model.put("authenticationError", "invalid user or password");
        return processUI("form", model);
    }
}
