package com.shebkoch.vm.api.model.entity;

import com.shebkoch.vm.api.model.iterators.EntityIterator;

public abstract class Entity {
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public abstract EntityIterator getNewIterator();
	@Override
	public String toString() {
		return ", id=" + id;
	}
}
