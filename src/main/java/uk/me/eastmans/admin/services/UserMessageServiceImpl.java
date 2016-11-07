package uk.me.eastmans.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.me.eastmans.admin.repositories.UserMessageRepository;

/**
 * Created by markeastman on 04/11/2016.
 */
@Service
public class UserMessageServiceImpl implements UserMessageService {
    @Autowired
    private UserMessageRepository userMessageRepository;

    @Transactional
    public void clearMessagesForUser( Long userId, Long maxId )
    {
        userMessageRepository.clearMessagesForUser( userId, maxId );
    }
    /*
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

     */
}
