package uk.me.eastmans.admin.ui;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.io.IOException;

/**
 * Created by markeastman on 26/09/2016.
 */
@ApplicationScoped
public class Application implements HtmlProducer {

    private TemplateEngine templateengine;

    public static final String CHARACTER_ENCODING      = "UTF-8";

    public Application()
    {
        // Initialise us to have the sensible defaults
        ServletContextTemplateResolver templateresolver = new ServletContextTemplateResolver();
        templateresolver.setPrefix("");
        templateresolver.setSuffix("htm");
        //templateresolver.setTemplateMode(config.getInitParameter(INIT_PARAM_TEMPLATEMODE));
        templateresolver.setCacheable(false);
        templateresolver.setCharacterEncoding(CHARACTER_ENCODING);

        templateengine = new TemplateEngine();
        templateengine.setTemplateResolver(templateresolver);
        //Set<IDialect> dialects = new HashSet<IDialect>();
        //dialects.add(new SpringStandardDialect());
        //dialects.add(new SqlDialect());
        //templateengine.setDialects(dialects);
        templateengine.initialize();
    }

    @Override
    public void processRequest(HttpServletResponse response) throws IOException{
        response.getWriter().print("Welcome to the new dashboard via template engine");
    }
}
