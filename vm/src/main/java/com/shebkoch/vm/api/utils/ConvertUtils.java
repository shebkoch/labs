package com.shebkoch.vm.api.utils;

import com.shebkoch.vm.api.JSON.JSONObject;
import com.shebkoch.vm.api.model.entity.Entity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertUtils {
	public static<T extends Entity> JSONObject toJson(List<T> list){
		Map<Integer,T> map = list.stream().collect(Collectors.toMap(T::getId, item -> item));
		return new JSONObject(map);
	}
}
