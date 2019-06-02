package com.shebkoch.vm.http.business;

import com.shebkoch.vm.api.model.entity.Entity;
import com.shebkoch.vm.core.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class GenericEntityService<T extends Entity> {
	private GenericDao<T> dao;

	@Autowired
	public GenericEntityService(GenericDao<T> dao) {
		this.dao = dao;
	}
	public List<T> getAll(){
		return dao.getAll();
	}
	public T getById(Integer id){
		return dao.get(id);
	}
	public T saveOrUpdate(T item) throws SQLException {
		return dao.saveOrUpdate(item);
	}

}
