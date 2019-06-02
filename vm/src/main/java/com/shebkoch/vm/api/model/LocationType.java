package com.shebkoch.vm.api.model;

public enum LocationType {
	FOREST(0), DESERT(1), DUNGEON(2), RIVER(3), OCEAN(4);

	private Integer code;

	public Integer getCode() {
		return code;
	}

	public static LocationType get(Integer type) {
		for (LocationType e : values()) {
			if (e.getCode().equals(type)) return e;
		}
		return null;
	}

	LocationType(Integer code) {
		this.code = code;
	}
}
