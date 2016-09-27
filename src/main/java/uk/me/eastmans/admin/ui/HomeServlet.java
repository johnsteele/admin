package uk.me.eastmans.admin.ui;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by markeastman on 26/09/2016.
 */
@WebServlet(value="/home", loadOnStartup=1)
public class HomeServlet extends HttpServlet{
    @Inject
    private Application application;

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
        application.processRequest(response);
//        String templatepath = request.getRequestURI().substring(request.getContextPath().length());
//        // Maps / to index.html
//        // FIXME: use welcome-file-list in web.xml
//        if (templatepath.equals("/")) {
//            templatepath += DEFAULT_PAGE;
//        }
//        response.setCharacterEncoding(CHARACTER_ENCODING);
//        templateengine.process(templatepath,
//                new WebContext(request, response, getServletContext()),
//                response.getWriter());
    }
}
