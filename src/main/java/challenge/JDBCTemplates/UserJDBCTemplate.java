package challenge.JDBCTemplates;

import challenge.SQLConstants;
import challenge.mappers.UserMapper;
import challenge.models.UserModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by davidbra on 6/30/17.
 */
public class UserJDBCTemplate extends DAO{

    /**
     * get user details
     * @param userID user id
     * @return user details
     */
    public UserModel getUser(int userID){
        Map<String, Integer > map = new HashMap<String,Integer >();
        map.put(SQLConstants.PERSON_ID, userID);
        return jdbcTemplateObject.queryForObject(SQLConstants.GET_USERS, map, new UserMapper());
    }

    /**
     * get id of certain user
     * @param userName
     * @return
     */
    public int getUserID(String userName){
        Map<String, String > map = new HashMap<String,String>();
        map.put(SQLConstants.HANDLE, userName);
        return jdbcTemplateObject.queryForObject(SQLConstants.GET_USERS_BY_HANDLE, map, new UserMapper()).getId();
    }

    /**
     * get all user details
     * @return
     */
    public List<UserModel> getAllUsers(){
        return jdbcTemplateObject.query(SQLConstants.GET_ALL_USERS, new UserMapper());
    }

}
