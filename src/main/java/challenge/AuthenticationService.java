package challenge;

import challenge.JDBCTemplates.UserJDBCTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by davidbra on 7/5/17.
 */
@Service
public class AuthenticationService implements UserDetailsService {

    private UserJDBCTemplate jdbc = new UserJDBCTemplate();

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        int userID = jdbc.getUserID(username);
        GrantedAuthority authority = new SimpleGrantedAuthority("USER");
        UserDetails userDetails = (UserDetails)new User(jdbc.getUser(userID).getHandle(),
                "1234", Arrays.asList(authority));
        return userDetails;
    }
}
