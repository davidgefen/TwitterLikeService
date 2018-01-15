package challenge.mappers;

import challenge.models.FollowModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by davidbra on 7/2/17.
 */
public class FollowMapper implements RowMapper<FollowModel> {

    public FollowModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new FollowModel(rs.getInt("id"), rs.getInt("person_id"), rs.getInt("follower_person_id"));
    }
}
