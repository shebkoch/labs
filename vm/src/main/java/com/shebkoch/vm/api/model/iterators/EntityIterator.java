package com.shebkoch.vm.api.model.iterators;

import com.shebkoch.vm.api.model.entity.Entity;

import java.util.ArrayList;

public abstract class EntityIterator<T extends Entity> {
    protected int current = -1;
    protected ArrayList<FieldTuple> fields = new ArrayList<FieldTuple>();
    protected T entity;

    public EntityIterator(T entity) {
        this.entity = entity;
    }

    public boolean hasNext() {
        return current < fields.size() - 1;
    }

    public Field next() {
        current++;
        Object value = getNextValue();
        String fieldName = getFieldName();
        String tableFieldName = getTableFieldName();
        return new Field(fieldName, tableFieldName, value);
    }
    protected String getFieldName() {
        return fields.get(current).fieldName;
    }

    protected String getTableFieldName() {
        return fields.get(current).tableFieldName;
    }

    protected abstract Object getNextValue();
    protected boolean checkNext(String fieldName) {
        return getFieldName().equals(fieldName);
    }
}
