package uk.me.eastmans.admin.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.security.Principal;

/**
 * Created by markeastman on 05/10/2016.
 */
public class SecurityRequestWrapper extends HttpServletRequestWrapper {

    private LoggedInUserPrincipal principal;

    public SecurityRequestWrapper(HttpServletRequest request, LoggedInUserPrincipal principal)
    {
        super(request);
        this.principal = principal;
    }

    @Override
    public Principal getUserPrincipal() {
        return principal;
    }

    @Override
    public boolean isUserInRole(String role)
    {
        // Need to check from LoggedInUserPrincipal
        return principal.isUserInRole(role);
    }


}
