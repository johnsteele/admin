package uk.me.eastmans.admin.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

/**
 * Created by markeastman on 26/09/2016.
 */
public interface HtmlProducer {
    public void processRequest(HttpServletRequest request, HttpServletResponse response, String templateName,
                               Locale locale) throws IOException;

    public void processRequest(HttpServletRequest request, HttpServletResponse response, String templateName,
                               Locale locale, Map attributes) throws IOException;
}
