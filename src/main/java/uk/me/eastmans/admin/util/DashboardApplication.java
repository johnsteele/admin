package uk.me.eastmans.admin.util;

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
    private PersonRepository personRepository;

    @Inject
    private UserMessageRepository userMessageRepository;

    @PostConstruct
    @Transactional
    void initialise()
    {
        // We need to create some dummy data
        Person user = new Person();
        user.setName("Steve Welsh");

        personRepository.create(user);

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
    }

}
