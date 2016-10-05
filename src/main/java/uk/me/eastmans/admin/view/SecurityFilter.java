package uk.me.eastmans.admin.view;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by markeastman on 03/10/2016.
 */
@WebFilter( urlPatterns = {"/app/*"})
public class SecurityFilter implements Filter{

    public static final String USER_KEY = "loggedInUser";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // We need to check if the user is logged on or not, so first cehck we have a session
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);
        String uri = req.getRequestURI();
        System.out.println( "Requested URI is " + uri );

        if (uri.startsWith("/app/login") || uri.startsWith("/app/authenticate"))
        {
            // Just route it on
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else if (session == null)
        {
            // we are not logged in so show log in screen
            res.sendRedirect("/app/login");
        }
        else
        {
            // Check to see if we have logged in yet
            Object user = session.getAttribute(USER_KEY);
            if (user == null)
            {
                // we are not logged in so show log in screen
                res.sendRedirect("/app/login");
            }
            else {
                // Just route it on
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
