package uk.me.eastmans.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.me.eastmans.admin.domain.User;

/**
 * Created by meastman on 23/12/15.
 */
@Service
public class CurrentUserDetailsService  implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CurrentUser loadUserByUsername(String loginName) throws UsernameNotFoundException {
        User user = userService.getUserByLoginName(loginName)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with login=%s was not found", loginName)));
        return new CurrentUser(user);
    }
}
