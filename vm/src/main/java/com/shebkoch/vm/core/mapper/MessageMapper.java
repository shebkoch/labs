package com.shebkoch.vm.core.mapper;

import com.shebkoch.vm.api.model.entity.Message;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MessageMapper implements IMapper<Message> {
	@Override
	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
		Message message = new Message();
		message.setPlayerFromId(rs.getInt("player_from_id"));
		message.setPlayerFromId(rs.getInt("player_to_id"));
		message.setText(rs.getString("text"));
		return message;
	}

	@Override
	public String getTableName() {
		return "Message";
	}
}
