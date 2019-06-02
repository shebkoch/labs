package com.shebkoch.vm.core.mapper;

import com.shebkoch.vm.api.model.entity.Entity;
import com.shebkoch.vm.api.model.iterators.EntityIterator;
import com.shebkoch.vm.api.model.iterators.Field;
import com.shebkoch.vm.core.dao.QueryContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IMapper<T extends Entity> extends RowMapper<T> {
	T mapRow(ResultSet rs, int rowNum) throws SQLException;

	public String getTableName();

	default String getFindByIdQuery() {
		return String.format("select * from %s where id = :id", getTableName());
	}

	default SqlParameterSource getParametersWithoutPK(T item) {
		SqlParameterSource parameters = new MapSqlParameterSource();
		EntityIterator<T> iterator = item.getNewIterator();
		while (iterator.hasNext()) {
			Field field = iterator.next();
			if(field.getFieldName().equals("id")) continue;
			((MapSqlParameterSource) parameters).addValue(field.getTableName(), field.getValue());
		}
		return parameters;
	}
	default QueryContainer getQueryContainer(T entity) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("update %s set ", getTableName()));
		MapSqlParameterSource parameters = new MapSqlParameterSource();

		fillQueryContainer(entity, stringBuilder, parameters);

		QueryContainer queryContainer = new QueryContainer();
		queryContainer.setParameters(parameters);
		queryContainer.setQUERY(stringBuilder.toString().replace(", where", " where"));

		return queryContainer;
	}

	default void queryContainerAdder(Object o, String s1, String s2, StringBuilder stringBuilder, MapSqlParameterSource parameters) {
		if (o != null) {
			stringBuilder.append(String.format("%s = :%s,", s1, s2));
			parameters.addValue(s2, o);
		}
	}

	default void fillQueryContainer(T item, StringBuilder stringBuilder, MapSqlParameterSource parameters) {
		EntityIterator<T> iterator = item.getNewIterator();
		while (iterator.hasNext()) {
			Field field = iterator.next();
			if(field.getFieldName().equals("id")) continue;
			queryContainerAdder(field.getValue(), field.getTableName(), field.getFieldName(), stringBuilder, parameters);
		}
		stringBuilder.append(" where id = :id;");
		parameters.addValue("id", item.getId());
	}
}
