package challenge;

/**
 * Created by davidbra on 7/2/17.
 */
public class SQLConstants {
    public static final String PERSON_ID = "personId";
    public static final String FOLLOWER_PERSON_ID = "followerPersonId";
    public static final String SEARCH = "search";
    public static final String HANDLE = "handle";

    //for SQL Command
    public static final String GET_MESSAGES = "select * from messages where person_id = :" + PERSON_ID;
    public static final String GET_MESSAGES_WITH_FILTER = "select * from messages where person_id = :" + PERSON_ID + " and content like :" + SEARCH;
    public static final String GET_USERS = "select * from people where id = :" + PERSON_ID;
    public static final String GET_USERS_BY_HANDLE = "select * from people where handle = :" + HANDLE;
    public static final String GET_ALL_USERS = "select * from people";
    public static final String GET_FOLLOWERS = "select * from followers where person_id = :" + PERSON_ID;
    public static final String GET_FOLLOWING = "select * from followers where follower_person_id = :" + FOLLOWER_PERSON_ID;
    public static final String START_FOLLOWING = "insert into followers (person_id, follower_person_id) values (:" + PERSON_ID + ", :" + FOLLOWER_PERSON_ID + ")";
    public static final String END_FOLLOWING = "delete from followers where person_id = :" + PERSON_ID + " and follower_person_id = :" + FOLLOWER_PERSON_ID;
    public static final String MOST_FOLLOWED_FOLLOWING = "select person_id as user, follower, popularity from followers inner join (select person_id as follower, count(follower_person_id) as popularity from followers group by  person_id) as a on a.follower = followers.follower_person_id where person_id = :" + PERSON_ID + " order by popularity desc limit 1";
}
