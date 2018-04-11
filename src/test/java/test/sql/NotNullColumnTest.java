package test.sql;

import com.sql.context.bean.Column;
import com.sql.context.service.NotNullColumnService;
import org.junit.After;
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
//        update 使用批量插入每次1000-2000,很快
//        在这里循环,使得内部事务能够提交,10w条数据1分钟
        Long now = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            logger.debug("this is times : " + i);
            notNullColumnService.insertTableNotNull(tableNotNull);
        }
        logger.debug("test time : " + (System.currentTimeMillis() - now) + "");

        now=System.currentTimeMillis();
        notNullColumnService.selectTableNotNull();
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {
    }

    @After
    public void drop() {
        notNullColumnService.dropTableNotNull();
    }

}
