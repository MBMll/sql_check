package com.sql.context.service;

import com.sql.context.bean.Column;

import java.util.List;

/**<h4>验证:</h4>
 * <p>应该尽量把字段设置为NOTNULL</p>
 * Created by xlc on 2018/4/2.
 */
public interface NotNullColumnService {

    List<Column> createTableNotNull();

    void createTableNull();

    void insertTableNotNull(List<Column> tableNotNull);

    void deleteTableNotNull();

    void dropTableNotNull();

    void selectTableNotNull();
}
