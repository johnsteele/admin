package uk.me.eastmans.admin.ui;

import uk.me.eastmans.admin.model.Person;
import uk.me.eastmans.admin.model.PersonRepository;
import uk.me.eastmans.admin.service.PersonService;

import javax.inject.Inject;
import javax.persistence.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by markeastman on 26/09/2016.
 */
@WebServlet(value="/home")
public class HomeServlet extends HttpServlet {
    @Inject
    private HtmlProducer uiProducer;

    @Inject
    private PersonService personService;

    public HomeServlet()
    {
        System.out.println( "HomeServlet created " + uiProducer );
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        checkDatabase();

        Map model = new HashMap();
        model.put( "username", "Mark Eastman" );
        uiProducer.processRequest(request,response, "home", request.getLocale(), model);

    }

    public void checkDatabase()
    {
        // Try out persistence
        personService.test();
    }
}
