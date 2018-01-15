package challenge.models;

import java.util.ArrayList;

/**
 * Created by davidbra on 7/3/17.
 */
public class UserFollowModel {
    //FollowModel
    private ArrayList<String> followers;
    private ArrayList<String> following;

    public ArrayList<String> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<String> followers) {
        this.followers = followers;
    }

    public ArrayList<String> getFollowing() {
        return following;
    }

    public void setFollowing(ArrayList<String> following) {
        this.following = following;
    }
}
