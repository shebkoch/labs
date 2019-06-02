package com.shebkoch.vm.core.dao;
import com.shebkoch.vm.api.model.entity.Entity;
import com.shebkoch.vm.core.mapper.IMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Component
public class GenericDao<T extends Entity> {
    private NamedParameterJdbcTemplate nJdbcTemplate;
    private IMapper<T> mapper;
    private SimpleJdbcInsert insertActor;

    @Autowired
    public GenericDao(JdbcTemplate jdbcTemplate, IMapper<T> mapper) {
        this.nJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        this.insertActor = new SimpleJdbcInsert(jdbcTemplate).withTableName(mapper.getTableName()).usingGeneratedKeyColumns("id");
        this.mapper = mapper;
    }

    public T get(Integer id) {
        SqlParameterSource parameters = new MapSqlParameterSource().addValue("id", id);
        return nJdbcTemplate.queryForObject(mapper.getFindByIdQuery(), parameters, mapper);
    }
    public List<T> getAll()  {
        final String QUERY = String.format("select * from %s", mapper.getTableName());
        return nJdbcTemplate.query(QUERY,mapper);
    }
    @Transactional
    protected Integer save(T item) throws SQLException {
        if (item.getId() == null){
            Number newId = insertActor.executeAndReturnKey(mapper.getParametersWithoutPK(item));
            return newId.intValue();
        } else {
            throw new SQLException(String.format("Attempt to save object with existing Id class: %s, id: %s", item.getClass(), item.getId()));
        }
    }

    @Transactional
    protected T update(T entity) throws SQLException  {
        QueryContainer queryContainer = mapper.getQueryContainer(entity);
        nJdbcTemplate.update(queryContainer.getQUERY(),queryContainer.getParameters());
        return null;
    }

    public T saveOrUpdate(T item) throws SQLException {
        if (item.getId() == null){
            Integer id  = this.save(item);
            item.setId(id);
            return item;
        } else {
            return this.update(item);
        }
    }
}
