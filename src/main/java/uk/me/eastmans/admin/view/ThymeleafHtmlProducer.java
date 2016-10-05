package uk.me.eastmans.admin.view;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import uk.me.eastmans.admin.view.HtmlProducer;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

/**
 * Created by markeastman on 26/09/2016.
 */
@ApplicationScoped
public class ThymeleafHtmlProducer implements HtmlProducer {

    private TemplateEngine templateengine;

    public static final String CHARACTER_ENCODING      = "UTF-8";

    public ThymeleafHtmlProducer()
    {
        // Initialise us to have the sensible defaults
        ServletContextTemplateResolver templateresolver = new ServletContextTemplateResolver();
        templateresolver.setPrefix("/WEB-INF/templates/");
        templateresolver.setSuffix(".html");
        templateresolver.setTemplateMode("HTML5");
        templateresolver.setCacheable(false);
        templateresolver.setCharacterEncoding(CHARACTER_ENCODING);

        templateengine = new TemplateEngine();
        templateengine.setTemplateResolver(templateresolver);
        templateengine.initialize();
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, String templateName,
                               Locale locale) throws IOException{
        response.setCharacterEncoding(CHARACTER_ENCODING);
        templateengine.process(templateName,
                new WebContext(request, response, request.getServletContext(), locale),response.getWriter());

    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, String templateName,
                               Locale locale, Map attributes) throws IOException{
        response.setCharacterEncoding(CHARACTER_ENCODING);
        templateengine.process(templateName,
              new WebContext(request, response, request.getServletContext(), locale, attributes),response.getWriter());

    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response, String templateName, Map attributes) throws IOException{
        response.setCharacterEncoding(CHARACTER_ENCODING);
        return templateengine.process(templateName,
                new WebContext(request, response, request.getServletContext(), request.getLocale(), attributes));

    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response, String templateName) throws IOException{
        response.setCharacterEncoding(CHARACTER_ENCODING);
        return templateengine.process(templateName,
                new WebContext(request, response, request.getServletContext(), request.getLocale()));

    }
}
