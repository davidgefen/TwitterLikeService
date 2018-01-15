package challenge.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by davidbra on 6/30/17.
 */
public class UserMessagesModel {

    private ArrayList<String> userMessages;//messages posted by user
    private ArrayList<Map<Integer,String>> followMessages;//messages posted by users that userName follows

    /**
     * constructor
     */
    public UserMessagesModel(){
        this.userMessages = new ArrayList<String>();
        this.followMessages = new ArrayList<Map<Integer,String>>();
    }

    public ArrayList<String> getUserMessages() {
        return userMessages;
    }

    /**
     * adds message to userMessages
     * @param message message to be pushed
     */
    public void pushUserMessages(MessageModel message) {
        this.userMessages.add(message.getMessage());
    }

    public ArrayList<Map<Integer,String>> getFollowMessages() {
        return followMessages;
    }

    /**
     * adds message to followMessages
     * @param message message to be pushed
     */
    public void pushFollowMessages(MessageModel message) {
        Map<Integer,String> value = new HashMap<Integer,String>();
        value.put(message.getPersonID(),message.getMessage());
        this.followMessages.add(value);
    }

    public void setUserMessages(List<MessageModel> userMessages) {
        for(MessageModel message : userMessages)
            pushUserMessages(message);
    }

    public void setFollowMessages(List<MessageModel> followMessages) {
        for(MessageModel message : followMessages)
            pushFollowMessages(message);
    }
}
