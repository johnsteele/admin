package uk.me.eastmans.admin.service;

import uk.me.eastmans.admin.model.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by markeastman on 03/10/2016.
 */
@ApplicationScoped
public class UserMessageService {

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserMessageRepository userMessageRepository;

    @Transactional
    public void sendMessageToUser(Long userId, UserMessageClassification classification, String text)
    {
        User p = userRepository.read(userId);

        UserMessage message = new UserMessage();
        message.setForWho( p );
        message.setClassification(classification);
        message.setMessage(text);
        userMessageRepository.create(message);
    }

    @Transactional
    public List getMessagesForUser(Long userId )
    {
        return userMessageRepository.getMessagesForUser( userId );
    }

    @Transactional
    public void clearMessages( Long userId, Long maxId )
    {
        userMessageRepository.clearMessages( userId, maxId );
    }
}
