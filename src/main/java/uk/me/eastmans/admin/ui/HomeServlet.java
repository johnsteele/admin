package uk.me.eastmans.admin.ui;

import uk.me.eastmans.admin.model.Person;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

    public HomeServlet()
    {
        System.out.println( "HomeServlet created " + uiProducer );
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
/*
        // Try out persistence
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Admin");
        EntityManager theManager = factory.createEntityManager();

        Person person = new Person();
        person.setFirstName("ana");
        theManager.persist(person);
        System.out.println(person.getId());

        Person p = (Person)theManager.find(Person.class, 1);
        System.out.println(person.getId());
*/
        Map model = new HashMap();
        model.put( "username", "Mark Eastman" );
        uiProducer.processRequest(request,response, "home", request.getLocale(), model);

    }
}
