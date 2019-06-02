package com.shebkoch.vm.api.model.iterators.entity;

import com.shebkoch.vm.api.model.entity.Player;
import com.shebkoch.vm.api.model.iterators.EntityIterator;
import com.shebkoch.vm.api.model.iterators.FieldTuple;

public class PlayerIterator extends EntityIterator<Player> {
	public PlayerIterator(Player entity) {
		super(entity);
		fields.add(new FieldTuple("id", "id"));
		fields.add(new FieldTuple("name", "location_type"));
		fields.add(new FieldTuple("playerclass","playerclass"));
		fields.add(new FieldTuple("email", "email"));
		fields.add(new FieldTuple("position","location_id"));
	}
	@Override
	protected Object getNextValue() {
		if (checkNext("id")) return entity.getId();
		if (checkNext("name")) return entity.getName();
		if (checkNext("playerclass")) return entity.getPlayerClass().getCode();
		if (checkNext("email")) return entity.getEmail();
		if (checkNext("position")) return entity.getPosition();
		throw new NullPointerException();
	}
}
