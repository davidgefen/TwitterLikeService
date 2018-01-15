package challenge.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import challenge.models.UserModel;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by davidbra on 6/30/17.
 */
public class UserMapper implements RowMapper<UserModel>{

    public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserModel(rs.getInt("id"),rs.getString("handle"),rs.getString("name"));
    }
}
