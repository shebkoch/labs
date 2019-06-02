package com.shebkoch.vm.core.mapper;

import com.shebkoch.vm.api.model.PlayerType;
import com.shebkoch.vm.api.model.entity.Player;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PlayerMapper implements IMapper<Player> {
	@Override
	public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
		Player player = new Player();
		player.setId(rs.getInt("id"));
		player.setEmail(rs.getString("email"));
		player.setLevel(rs.getInt("level"));
		player.setName(rs.getString("name"));
		player.setPlayerClass(PlayerType.get(rs.getInt("playerclass")));
		player.setPosition(rs.getInt("location_id"));
		return player;
	}

	@Override
	public String getTableName() {
		return "Player";
	}
}
