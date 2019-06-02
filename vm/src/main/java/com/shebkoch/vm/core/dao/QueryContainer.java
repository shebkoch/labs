package com.shebkoch.vm.core.dao;

import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class QueryContainer {
	private String QUERY;

	private SqlParameterSource parameters;

	public String getQUERY() {
		return QUERY;
	}

	public void setQUERY(String QUERY) {
		this.QUERY = QUERY;
	}

	public SqlParameterSource getParameters() {
		return parameters;
	}

	public void setParameters(SqlParameterSource parameters) {
		this.parameters = parameters;
	}
}
