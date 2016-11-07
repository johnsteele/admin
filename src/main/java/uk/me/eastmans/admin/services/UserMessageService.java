package uk.me.eastmans.admin.services;

import org.springframework.stereotype.Service;

/**
 * Created by markeastman on 07/11/2016.
 */
public interface UserMessageService {
    void clearMessagesForUser( Long userId, Long maxId );
}
