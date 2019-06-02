package com.shebkoch.vm.api.model.entity;

import com.shebkoch.vm.api.model.PlayerType;
import com.shebkoch.vm.api.model.iterators.EntityIterator;
import com.shebkoch.vm.api.model.iterators.entity.PlayerIterator;

public class Player extends Entity {
	private String name;
	private PlayerType playerClass;
	private String email;
	private Integer level;
	private Integer positionId;

	public Player() {
	}

	public Player(String name, PlayerType playerClass, String email, Integer level, Integer position) {
		this.name = name;
		this.playerClass = playerClass;
		this.email = email;
		this.level = level;
		this.positionId = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerType getPlayerClass() {
		return playerClass;
	}

	public void setPlayerClass(PlayerType playerClass) {
		this.playerClass = playerClass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getPosition() {
		return positionId;
	}

	public void setPosition(Integer positionId) {
		this.positionId = positionId;
	}
	@Override
	public EntityIterator getNewIterator() {
		return new PlayerIterator(this);
	}
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Player{");
		sb.append(" name='").append(name).append('\'');
		if (playerClass != null)
			sb.append(", playerClass=").append(playerClass);
		if (email != null)
			sb.append(", email='").append(email).append('\'');
		if (level != null)
			sb.append(", level=").append(level);
		if (positionId != null)
			sb.append(", position=").append(positionId);
		sb.append(super.toString());
		sb.append("} ");
		return sb.toString();
	}
}
