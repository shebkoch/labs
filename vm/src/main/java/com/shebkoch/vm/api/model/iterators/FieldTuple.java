package com.shebkoch.vm.api.model.iterators;

public class FieldTuple {
    public String fieldName;
    public String tableFieldName;

    public FieldTuple(String fieldName, String tableFieldName) {
        this.fieldName = fieldName;
        this.tableFieldName = tableFieldName;
    }
}
