package uk.me.eastmans.admin.ui;

import uk.me.eastmans.admin.service.PersonService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by markeastman on 26/09/2016.
 */
@WebServlet(value="/app/login")
public class LoginServlet extends HttpServlet {
    @Inject
    private HtmlProducer uiProducer;

    @Inject
    private PersonService personService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        uiProducer.processRequest(request,response, "login", request.getLocale());

    }
}
