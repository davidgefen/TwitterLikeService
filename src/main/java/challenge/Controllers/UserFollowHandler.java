package challenge.Controllers;

import challenge.JDBCTemplates.FollowJDBCTemplate;
import challenge.JDBCTemplates.UserJDBCTemplate;
import challenge.models.FollowModel;
import challenge.models.PopularityModel;
import challenge.models.UserFollowModel;
import challenge.models.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidbra on 7/3/17.
 */
public class UserFollowHandler {

    private FollowJDBCTemplate jdbcFollow = new FollowJDBCTemplate();
    private UserJDBCTemplate jdbcUser = new UserJDBCTemplate();
    private UserFollowModel uf = new UserFollowModel();



    /**
     * get list of users followers, and users this user is following
     * @param userID user id
     * @return list of followers and following
     */
    private UserFollowModel getUserFollow(int userID){
        //get list of users userID is following
        List<FollowModel> following = jdbcFollow.getFollowing(userID);
        ArrayList<String> followingHandles = new ArrayList<String>();
        for (FollowModel follow : following) {
            //get names of followed
            followingHandles.add(jdbcUser.getUser(follow.getPersonID()).getHandle());
        }
        uf.setFollowing(followingHandles);

        //get list of users userID is follower of
        List<FollowModel> follower = jdbcFollow.getFollowers(userID);
        ArrayList<String> followerHandles = new ArrayList<String>();
        for (FollowModel follow : follower) {
            //get names of following
            followerHandles.add(jdbcUser.getUser(follow.getFollowerPersonID()).getHandle());
        }
        uf.setFollowers(followerHandles);

        return uf;
    }

    /**
     * get list of users followers, and users this user is following
     * @param userName user name
     * @return list of followers and following
     */
    public UserFollowModel getUserFollow(String userName){
        return getUserFollow(jdbcUser.getUserID(userName));
    }

    /**
     * userName start following userToFollow
     * @param userName used id
     * @param userToFollow used id
     */
    public void startFollowing(String userName, String userToFollow){
        jdbcFollow.startFollowing(jdbcUser.getUserID(userName), jdbcUser.getUserID(userToFollow));
    }

    /**
     * userName end following userToFollow
     * @param userName used id
     * @param userToFollow used id
     */
    public void endFollowing(String userName, String userToFollow){
        jdbcFollow.endFollowing(jdbcUser.getUserID(userName), jdbcUser.getUserID(userToFollow));
    }

    public List<PopularityModel> getMostPopularAll(){

        List<UserModel> users = jdbcUser.getAllUsers();
        List<PopularityModel> result = new ArrayList<PopularityModel>();

        for (UserModel user : users){
            result.add(jdbcFollow.getMostPopular(user.getId()));
        }

        return result;
    }
}
