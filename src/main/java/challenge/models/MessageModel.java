package challenge.models;

/**
 * Created by davidbra on 7/2/17.
 */
public class MessageModel extends DataModel {

    private int personID;
    private String Message;

    public MessageModel(int id, int personID, String Message) {
        super.setId(id);
        this.personID = personID;
        this.Message = Message;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
