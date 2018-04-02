package com.sql.context.bean;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by xlc on 2018/4/2.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Column {

    private String name;
    private String type;
    private String isNull;
    private String primary;
    private String unique;
    private String defaultValue;
    private String comment;
}
