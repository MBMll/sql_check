package test.sql;

import com.sql.context.bean.Column;
import com.sql.context.service.NotNullColumnService;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import test.BaseTest;

import java.util.List;

/**
 * Created by xlc on 2018/4/2.
 */
@Transactional()
//@TransactionConfiguration(defaultRollback = false)
public class NotNullColumnTest extends BaseTest {
    @Autowired
    NotNullColumnService notNullColumnService;
    private List<Column> tableNotNull;

    @Override
    public void select() {

    }

    @Before
    public void before() {
        tableNotNull = notNullColumnService.createTableNotNull();

        notNullColumnService.createTableNull();
    }

    @Override
    public void insert() {
//        notNullColumnService.insertNotNull();
//        在一个事务中插入1kw50列的数据,用了一天一夜多还没结束
        notNullColumnService.insertTableNotNull(tableNotNull);
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

}
