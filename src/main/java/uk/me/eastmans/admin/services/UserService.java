package uk.me.eastmans.admin.services;

import uk.me.eastmans.admin.domain.User;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by markeastman on 07/11/2016.
 */
public interface UserService {
    Optional<User> getUserById(long id);

    Optional<User> getUserByLoginName(String loginName);

    Collection<User> getAllUsers();

//    User create(UserCreateForm form);

}
