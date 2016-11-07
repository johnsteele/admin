package uk.me.eastmans.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uk.me.eastmans.admin.domain.User;
import uk.me.eastmans.admin.repositories.UserRepository;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by markeastman on 04/11/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserById(long id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<User> getUserByLoginName(String loginName) {
        return userRepository.findOneByLoginName(loginName);
    }

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll(new Sort("email"));
    }

    /*
    @Override
    public User create(UserCreateForm form) {
        User user = new User();
        user.setLoginName(form.getEmail());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        return userRepository.save(user);
    }
    /*
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

     */
}
