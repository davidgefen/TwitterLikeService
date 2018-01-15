package challenge.Controllers;

import challenge.JDBCTemplates.FollowJDBCTemplate;
import challenge.JDBCTemplates.MessagesJDBCTemplate;
import challenge.JDBCTemplates.UserJDBCTemplate;
import challenge.models.FollowModel;
import challenge.models.UserMessagesModel;

import java.util.List;

/**
 * Created by davidbra on 7/2/17.
 */
public class UserMessagesHandler {

    private MessagesJDBCTemplate jdbcMessage = new MessagesJDBCTemplate();
    private FollowJDBCTemplate jdbcFollow = new FollowJDBCTemplate();
    private UserJDBCTemplate jdbcUser = new UserJDBCTemplate();


    /**
     * returns UserMessagesModel with messages of user and messages from followed users
     * @param userID user ID of current user
     * @return UserMessagesModel with messages of user and messages from followed users
     */
    private UserMessagesModel getUserMessages(int userID, String search){

        UserMessagesModel um = new UserMessagesModel();

        //get users messages
        um.setUserMessages(jdbcMessage.getMessages(userID, search));

        //get messages from users userID is following
        List<FollowModel> following = jdbcFollow.getFollowing(userID);
        for (FollowModel follow : following) {
            um.setFollowMessages(jdbcMessage.getMessages(follow.getPersonID(), search));
        }

        return um;
    }

    /**
     * returns UserMessagesModel with messages of user and messages from followed users
     * @param userName user name of current user
     * @return UserMessagesModel with messages of user and messages from followed users
     */
    public UserMessagesModel getUserMessages(String userName, String search){
		return getUserMessages(jdbcUser.getUserID(userName), search);
    }
}
