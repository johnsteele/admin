package uk.me.eastmans.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import uk.me.eastmans.admin.domain.UserMessage;
import uk.me.eastmans.admin.repositories.UserMessageRepository;
import uk.me.eastmans.admin.services.CurrentUser;

import java.util.Collections;
import java.util.List;

/**
 * Created by markeastman on 07/11/2016.
 */
@Controller
public class BaseController {
    @Autowired
    private UserMessageRepository userMessageRepository;

    @ModelAttribute("userMessages")
    public List<UserMessage> userMessages()
    {
        List<UserMessage> result = Collections.EMPTY_LIST;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
        {
            CurrentUser user = (CurrentUser)auth.getPrincipal();
            result = userMessageRepository.findMessagesForUser(user.getId());
        }
        return result;
    }
}
