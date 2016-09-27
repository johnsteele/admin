package uk.me.eastmans.admin.ui;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by markeastman on 26/09/2016.
 */
public interface HtmlProducer {
    public void processRequest(HttpServletResponse response) throws IOException;
}
