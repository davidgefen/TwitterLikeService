package challenge.Servlets;

import challenge.Controllers.UserFollowHandler;
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
public class GetUserFollow {

    @RequestMapping(value = "/follow", method = RequestMethod.GET)
    public String follow(@AuthenticationPrincipal final UserDetails user) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        UserFollowHandler follow = new UserFollowHandler();
        return om.writeValueAsString(follow.getUserFollow(user.getUsername()));
    }

}
