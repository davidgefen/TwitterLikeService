package challenge.JDBCTemplates;

import challenge.SQLConstants;
import challenge.models.MessageModel;
import challenge.mappers.MessageMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by davidbra on 7/2/17.
 */
public class MessagesJDBCTemplate extends DAO {

    private static final String INCLUDE_SURROUNDING = "%";

    /**
     * get list of users messages, as well as users followed messages
     * @param userID user to perform act on
     * @param search parameter to filter message results
     * @return list of users messages, as well as users followed messages
     */
    public List<MessageModel> getMessages(int userID, String search){
        if(search != null) {
            StringBuilder filter = new StringBuilder();
            filter.append(INCLUDE_SURROUNDING).append(search).append(INCLUDE_SURROUNDING);
            Map<String, String > map = new HashMap<String,String >();
            map.put(SQLConstants.PERSON_ID,((Integer)userID).toString());
            map.put(SQLConstants.SEARCH,filter.toString());
            return jdbcTemplateObject.query(SQLConstants.GET_MESSAGES_WITH_FILTER, map, new MessageMapper());
        }
        else {
            Map<String, Integer > map = new HashMap<String,Integer >();
            map.put(SQLConstants.PERSON_ID,userID);
            return jdbcTemplateObject.query(SQLConstants.GET_MESSAGES, map, new MessageMapper());
        }
    }
}
