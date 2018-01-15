package challenge.JDBCTemplates;

import challenge.SQLConstants;
import challenge.mappers.FollowMapper;
import challenge.mappers.PopularityMapper;
import challenge.models.FollowModel;
import challenge.models.PopularityModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by davidbra on 7/2/17.
 */
public class FollowJDBCTemplate  extends DAO {

    /**
     * get followers of a specific user
     * @param userID user to fint folowers for
     * @return list of followers
     */
    public List<FollowModel> getFollowers(int userID){
        Map<String, Integer> map = new HashMap<String,Integer>();
        map.put(SQLConstants.PERSON_ID,userID);
        return jdbcTemplateObject.query(SQLConstants.GET_FOLLOWERS, map, new FollowMapper());
    }

    /**
     * get users following list
     * @param userID to find following for
     * @return list of following users
     */
    public List<FollowModel> getFollowing(int userID){
        Map<String, Integer> map = new HashMap<String,Integer>();
        map.put(SQLConstants.FOLLOWER_PERSON_ID,userID);
        return jdbcTemplateObject.query(SQLConstants.GET_FOLLOWING,map, new FollowMapper());
    }

    /**
     * add a new follow element
     * @param userID
     * @param userIDToFollow
     */
    @Transactional
    public void startFollowing(int userID, int userIDToFollow){
        Map<String, Integer> map = new HashMap<String,Integer>();
        map.put(SQLConstants.PERSON_ID,userIDToFollow);
        map.put(SQLConstants.FOLLOWER_PERSON_ID,userID);
        jdbcTemplateObject.update(SQLConstants.START_FOLLOWING, map);
    }

    /**
     * remove a follow element
     * @param userID
     * @param userIDToUnFollow
     */
    @Transactional
    public void endFollowing(int userID, int userIDToUnFollow){
        Map<String, Integer> map = new HashMap<String,Integer>();
        map.put(SQLConstants.PERSON_ID,userIDToUnFollow);
        map.put(SQLConstants.FOLLOWER_PERSON_ID,userID);
        jdbcTemplateObject.update(SQLConstants.END_FOLLOWING,map);
    }

    /**
     * get most popular follower
     * @param userID user to execute function on
     * @return most popular follower
     */
    public PopularityModel getMostPopular(int userID){
        Map<String, Integer> map = new HashMap<String,Integer>();
        map.put(SQLConstants.PERSON_ID,userID);
        return jdbcTemplateObject.queryForObject(SQLConstants.MOST_FOLLOWED_FOLLOWING,map, new PopularityMapper());
    }
}
