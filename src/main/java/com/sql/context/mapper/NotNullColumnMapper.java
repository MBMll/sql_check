package com.sql.context.mapper;

import com.sql.context.bean.Column;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xlc on 2018/4/2.
 */
public interface NotNullColumnMapper {
    void createTableNotNull(@Param("columns") ArrayList<Column> columns);

    void insertTableNotNull(@Param("columns") List columns,
                            @Param("rows") List rows);
}
