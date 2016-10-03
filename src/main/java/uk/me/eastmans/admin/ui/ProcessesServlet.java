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
@WebServlet(value="/app/processes")
public class ProcessesServlet extends HttpServlet {
    @Inject
    private HtmlProducer uiProducer;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Map model = new HashMap();
        model.put( "username", "Mark Eastman" );
        uiProducer.processRequest(request,response, "processes", request.getLocale(), model);
    }
}
