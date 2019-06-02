package com.shebkoch.vm.api.model.iterators;

public class Field {
    private String fieldName;
    private String tableName;
    private Object value;
    public Field(String fieldName, String tableName, Object value) {
        this.fieldName = fieldName;
        this.tableName = tableName;
        this.value = value;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
