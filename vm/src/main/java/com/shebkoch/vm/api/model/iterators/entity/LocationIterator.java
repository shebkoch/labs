package com.shebkoch.vm.api.model.iterators.entity;

import com.shebkoch.vm.api.model.entity.Location;
import com.shebkoch.vm.api.model.entity.Player;
import com.shebkoch.vm.api.model.iterators.EntityIterator;
import com.shebkoch.vm.api.model.iterators.FieldTuple;

public class LocationIterator extends EntityIterator<Location> {
	public LocationIterator(Location entity) {
		super(entity);
		fields.add(new FieldTuple("locationId", "id"));
		fields.add(new FieldTuple("description", "description"));
		fields.add(new FieldTuple("locationType","locationType"));
	}
	@Override
	protected Object getNextValue() {
		if (checkNext("locationId")) return entity.getId();
		if (checkNext("description")) return entity.getDescription();
		if (checkNext("locationType")) return entity.getLocationType().getCode();
		throw new NullPointerException();
	}
}
