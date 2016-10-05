package uk.me.eastmans.admin.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;

/**
 * Created by markeastman on 05/10/2016.
 */
public class SecurityRequestWrapper extends HttpServletRequestWrapper {

    public SecurityRequestWrapper(HttpServletRequest request)
    {
        super(request);
    }

    @Override
    public Principal getUserPrincipal() {
        return new UserPrincipal(); // We should get this from the database
    }

    @Override
    public boolean isUserInRole(String role)
    {
        return true; // We should get this from the database
    }


    static class UserPrincipal implements Principal
    {
        @Override
        public String getName() {
            return "admin";
        }
    }
}
