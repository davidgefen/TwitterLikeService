package challenge.models;

/**
 * Created by davidbra on 7/5/17.
 */
public class PopularityModel {

    private int user;
    private int mostPopularFollower;

    public PopularityModel(int user, int mostPopularFollower) {
        this.user = user;
        this.mostPopularFollower = mostPopularFollower;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getMostPopularFollower() {
        return mostPopularFollower;
    }

    public void setMostPopularFollower(int mostPopularFollower) {
        this.mostPopularFollower = mostPopularFollower;
    }
}
