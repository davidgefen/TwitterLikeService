package challenge.models;

/**
 * Created by davidbra on 7/2/17.
 */
public class FollowModel extends DataModel {

    private int personID;
    private int followerPersonID;

    public FollowModel(int id, int personID, int followerPersonID) {
        super.setId(id);
        this.personID = personID;
        this.followerPersonID = followerPersonID;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public int getFollowerPersonID() {
        return followerPersonID;
    }

    public void setFollowerPersonID(int followerPersonID) {
        this.followerPersonID = followerPersonID;
    }
}
