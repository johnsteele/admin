package uk.me.eastmans.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uk.me.eastmans.admin.repositories.UserMessageRepository;
import uk.me.eastmans.admin.services.CurrentUser;
import uk.me.eastmans.admin.services.UserMessageService;

import java.time.LocalDateTime;

/**
 * Created by markeastman on 26/09/2016.
 */
@Controller
public class AjaxController {
    @Autowired
    private UserMessageService userMessageService;

    @PostMapping(path = "/clearMessages/{maxId}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String index(@PathVariable Long maxId, Authentication auth) {
        if (auth != null)
        {
            CurrentUser user = (CurrentUser)auth.getPrincipal();
            userMessageService.clearMessagesForUser(user.getId(), maxId);
        }
        return "done";
    }
}
