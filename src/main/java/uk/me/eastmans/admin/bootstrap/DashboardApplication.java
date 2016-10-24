package uk.me.eastmans.admin.bootstrap;

import uk.me.eastmans.admin.model.*;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Created by markeastman on 06/10/2016.
 */
@Startup
@Singleton
public class DashboardApplication {

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserMessageRepository userMessageRepository;

    @PostConstruct
    void initialise() {
        initDatabase();
    }

    @Transactional
    private void initDatabase()
    {
        // We need to create some dummy data
        User user = new User();
        user.setName("Steve Welsh");
        user.setLoginName("admin");
        user.setPassword("admin");

        userRepository.create(user);

        UserMessage msg1 = new UserMessage();
        msg1.setForWho(user);
        msg1.setClassification(UserMessageClassification.INFO);
        msg1.setMessage("Created at startup");
        userMessageRepository.create(msg1);

        UserMessage msg2 = new UserMessage();
        msg2.setForWho(user);
        msg2.setClassification(UserMessageClassification.WARNING);
        msg2.setMessage("Will be deleted at destroy time");
        userMessageRepository.create(msg2);

        User user2 = new User();
        user2.setName("Mark Eastman");
        user2.setLoginName("me");
        user2.setPassword("me");

        userRepository.create(user2);

    }

}
