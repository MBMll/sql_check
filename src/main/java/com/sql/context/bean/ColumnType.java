package com.sql.context.bean;

/**
 * Created by xlc on 2018/4/3.
 */
public enum ColumnType {
    VARCHAR(50, "VARCHAR"), INT(0, "INT"), TEXT(0, "TEXT"), CHAR, DATETIME, TIMESTAMP;
    private int length;
    private String value;

    ColumnType() {
    }

    ColumnType(int length, String value) {
        this.length = length;
        this.value = value;
    }

    public String getValue() {
        return value + (length > 0 ? "(" + length + ")" : "");
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
