package com.sql.context.service.impl;

import com.sql.context.bean.Column;
import com.sql.context.bean.ColumnType;
import com.sql.context.mapper.NotNullColumnMapper;
import com.sql.context.service.NotNullColumnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static com.sql.context.bean.ColumnType.*;

/**
 * Created by xlc on 2018/4/2.
 */
@Transactional
@Service("notNullColumnService")
public class NotNullColumnServiceImpl implements NotNullColumnService {
    @Autowired
    private NotNullColumnMapper notNullColumnMapper;
    private static final Logger logger = LoggerFactory.getLogger(NotNullColumnService.class);

    @Override
    public List<Column> createTableNotNull() {
        ColumnType[] columnTypes = {VARCHAR, INT, TEXT};
        ArrayList<Column> columns = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Column column = new Column();
            column.setName("column_" + i);
            column.setIsNull("NOT NULL");
            column.setType(columnTypes[new Random().nextInt(columnTypes.length)].getValue());
            columns.add(column);
        }
        notNullColumnMapper.createTableNotNull(columns);
        return columns;
    }

    @Override
    public void createTableNull() {

    }

    @Override
    public void insertTableNotNull(List<Column> tableNotNull) {
        List list = new ArrayList();
        for (Column column : tableNotNull) {
            switch (column.getType()) {
                case "INT":
                    list.add(new Random().nextInt(Integer.MAX_VALUE));
                    break;
                case "VARCHAR(50)":
                case "TEXT":
                default:
                    list.add(new Random().nextDouble() + "");
            }
        }
        logger.debug("insertTableNotNull start : " + new Date());
        List<List> rows = new ArrayList<>();

        for (int j = 0; j < 1000; j++) {
            rows.add(list);
        }
        notNullColumnMapper.insertTableNotNull(tableNotNull, rows);
        logger.debug("insertTableNotNull end : " + new Date());
    }

    @Override
    public void deleteTableNotNull() {
        notNullColumnMapper.deleteTableNotNull();
    }

    @Override
    public void dropTableNotNull() {
        notNullColumnMapper.dropTableNotNull();
    }

    @Override
    public void selectTableNotNull() {

    }
}
