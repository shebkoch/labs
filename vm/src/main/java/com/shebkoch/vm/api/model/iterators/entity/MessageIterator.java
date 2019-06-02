package com.shebkoch.vm.api.model.iterators.entity;

import com.shebkoch.vm.api.model.entity.Location;
import com.shebkoch.vm.api.model.entity.Message;
import com.shebkoch.vm.api.model.iterators.EntityIterator;
import com.shebkoch.vm.api.model.iterators.FieldTuple;

public class MessageIterator extends EntityIterator<Message> {
	public MessageIterator(Message entity) {
		super(entity);
		fields.add(new FieldTuple("messageId", "id"));
		fields.add(new FieldTuple("playerFrom", "player_from_id"));
		fields.add(new FieldTuple("playerTo","player_to_id"));
		fields.add(new FieldTuple("messageText","text"));
	}
	@Override
	protected Object getNextValue() {
		if (checkNext("messageId")) return entity.getId();
		if (checkNext("playerFrom")) return entity.getPlayerFromId();
		if (checkNext("playerTo")) return entity.getPlayerToId();
		if (checkNext("messageText")) return entity.getText();
		throw new NullPointerException();
	}
}
