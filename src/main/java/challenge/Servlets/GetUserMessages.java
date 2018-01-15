package challenge.Servlets;

import challenge.ChallengeConstants;
import challenge.Controllers.UserMessagesHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by davidbra on 7/2/17.
 */
@Controller
@RestController
@RequestMapping("/service")
public class GetUserMessages {

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public String messages(@AuthenticationPrincipal final UserDetails user, final HttpServletRequest request) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        UserMessagesHandler messages = new UserMessagesHandler();
        return om.writeValueAsString(messages.getUserMessages(user.getUsername(), request.getParameter(ChallengeConstants.FILTER_ARG)));
    }

}
