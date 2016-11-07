package uk.me.eastmans.admin.bootstrap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import uk.me.eastmans.admin.domain.Role;
import uk.me.eastmans.admin.domain.User;
import uk.me.eastmans.admin.domain.UserMessage;
import uk.me.eastmans.admin.domain.UserMessageClassification;
import uk.me.eastmans.admin.repositories.UserMessageRepository;
import uk.me.eastmans.admin.repositories.UserRepository;

/**
 * Created by markeastman on 06/10/2016.
 */
@Component
public class AdminTestData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMessageRepository userMessageRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // We need to create some dummy data
        User user = new User();
        user.setName("Steve Welsh");
        user.setLoginName("admin");
        user.setPasswordHash(encoder.encode("admin"));
        user.setRole(Role.ADMIN);

        userRepository.save(user);

        UserMessage msg1 = new UserMessage();
        msg1.setForWho(user);
        msg1.setClassification(UserMessageClassification.INFO);
        msg1.setMessage("Created at startup");
        userMessageRepository.save(msg1);

        UserMessage msg2 = new UserMessage();
        msg2.setForWho(user);
        msg2.setClassification(UserMessageClassification.WARNING);
        msg2.setMessage("Will be deleted at destroy time");
        userMessageRepository.save(msg2);

        User user2 = new User();
        user2.setName("Mark Eastman");
        user2.setLoginName("me");
        user2.setPasswordHash(encoder.encode("me"));
        user2.setRole(Role.USER);

        userRepository.save(user2);
    }
}
