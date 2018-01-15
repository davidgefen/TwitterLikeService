package challenge.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import challenge.models.MessageModel;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by davidbra on 6/30/17.
 */
public class MessageMapper implements RowMapper<MessageModel>{

    public MessageModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new MessageModel(rs.getInt("id"), rs.getInt("person_id"), rs.getString("content"));
    }
}
