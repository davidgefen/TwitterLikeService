package challenge.mappers;

import challenge.models.PopularityModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by davidbra on 7/5/17.
 */
public class PopularityMapper implements RowMapper<PopularityModel> {
    public PopularityModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PopularityModel(rs.getInt("user"), rs.getInt("follower"));
    }
}
