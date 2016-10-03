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
@WebServlet(value="/app/loginForm")
public class LoginFormServlet extends HttpServlet {
    @Inject
    private HtmlProducer uiProducer;

    @Inject
    private PersonService personService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String user = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println( "User and password " + user + "," + password );

        if ("admin".equals(user) && "admin".equals(password))
        {
            // All ok
            HttpSession session = request.getSession();
            session.setAttribute( SecurityFilter.USER_KEY, user );
            response.sendRedirect("home");
        }
        else {
            Map errors = new HashMap();
            errors.put("error", "invalid user or password");
            uiProducer.processRequest(request, response, "login", request.getLocale(), errors);
        }

    }
}
