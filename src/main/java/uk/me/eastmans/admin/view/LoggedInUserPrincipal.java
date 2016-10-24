package uk.me.eastmans.admin.view;

import uk.me.eastmans.admin.model.User;

import java.security.Principal;

/**
 * Created by markeastman on 24/10/2016.
 */
public class LoggedInUserPrincipal implements Principal
{
    private Long id = null;
    private String name = "notLoggedIn";

    public LoggedInUserPrincipal( User user )
    {
        id = user.getId();
        name = user.getName();
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getName()
    {
        return name;
    }

    public boolean isUserInRole(String role)
    {
        return true;
    }
}
