package uk.me.eastmans.admin.ui;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by markeastman on 26/09/2016.
 */
@WebServlet(value="/home", loadOnStartup=1)
public class HomeServlet extends HttpServlet {
    @Inject
    private HtmlProducer uiProducer;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        processRequest(request, response);
    }

    /**
     * Find and process a thymeleaf template with the name that matches the URL.
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Map model = new HashMap();
        model.put( "username", "Mark Eastman" );
        uiProducer.processRequest(request,response, "home", request.getLocale(), model);
    }
}
