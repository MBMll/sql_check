package test.sql;

import com.sql.context.service.TestService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.BaseTest;

import java.util.List;

/**
 * Created by xlc on 2018/4/1.
 */
public class TestBaseTest extends BaseTest {
    @Autowired
    private TestService testService;

    @Test
    public void test_list() {
        List<Integer> select = testService.select();
        Assert.assertNotNull(select);
        logger.debug(this.getClass().getCanonicalName(), select);
    }
}
