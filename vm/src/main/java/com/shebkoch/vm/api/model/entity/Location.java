package com.shebkoch.vm.api.model.entity;

import com.shebkoch.vm.api.model.LocationType;
import com.shebkoch.vm.api.model.iterators.EntityIterator;
import com.shebkoch.vm.api.model.iterators.entity.LocationIterator;

public class Location extends Entity {
	private String description;
	private LocationType locationType;

	public Location(String description, LocationType locationType) {
		this.description = description;
		this.locationType = locationType;
	}

	public Location() {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocationType getLocationType() {
		return locationType;
	}

	public void setLocationType(LocationType locationType) {
		this.locationType = locationType;
	}

	@Override
	public EntityIterator getNewIterator() {
		return new LocationIterator(this);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Location{");
		sb.append(" description='").append(description).append('\'');
		if (locationType != null)
			sb.append(", locationType=").append(locationType);
		sb.append(super.toString());
		sb.append("} ");
		return sb.toString();
	}
}
