package com.shebkoch.vm.api.model.entity;

import com.shebkoch.vm.api.model.iterators.EntityIterator;
import com.shebkoch.vm.api.model.iterators.entity.MessageIterator;

public class Message extends Entity {
	private Integer playerFromId;
	private Integer playerToId;
	private String text;

	public Message() {
	}

	public Message(Integer playerFromId, Integer playerToId, String text) {
		this.playerFromId = playerFromId;
		this.playerToId = playerToId;
		this.text = text;
	}

	public Integer getPlayerFromId() {
		return playerFromId;
	}

	public void setPlayerFromId(Integer playerFromId) {
		this.playerFromId = playerFromId;
	}

	public Integer getPlayerToId() {
		return playerToId;
	}

	public void setPlayerToId(Integer playerToId) {
		this.playerToId = playerToId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	@Override
	public EntityIterator getNewIterator() {
		return new MessageIterator(this);
	}
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Message{");
		sb.append(" playerFromId=").append(playerFromId);
		if (playerToId != null)
			sb.append(", playerToId=").append(playerToId);
		if (text != null)
			sb.append(", text='").append(text).append('\'');
		sb.append(super.toString());
		sb.append("} ");
		return sb.toString();
	}
}
