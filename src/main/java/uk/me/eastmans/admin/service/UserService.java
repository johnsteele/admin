package uk.me.eastmans.admin.service;

import uk.me.eastmans.admin.model.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Created by markeastman on 03/10/2016.
 */
@ApplicationScoped
public class UserService {

    @Inject
    private UserRepository userRepository;

    public User getUserWithLogin(String name, String password)
    {
        return userRepository.getUserWithLogin(name,password);
    }

    @Transactional
    public void test()
    {
        User user = new User();
        user.setName("ana");
        userRepository.create(user);
        System.out.println("ana has id " + user.getId());

        User p = userRepository.read(1L);
        System.out.println("User with id=1 is " + p.getName());
    }

}
