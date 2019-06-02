package com.shebkoch.vm.api.model;

public enum PlayerType {
	KNIGHT(0), WIZARD(1), THIEF(2), PALADIN(3);

	private int code;

	public Integer getCode() {
		return code;
	}

	public static PlayerType get(int type) {
		for (PlayerType e : values()) {
			if (e.getCode().equals(type)) return e;
		}
		return null;
	}

	PlayerType(Integer code) {
		this.code = code;
	}
}
