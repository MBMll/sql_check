package com.sql.context.service.impl;

import com.sql.context.mapper.TestMapper;
import com.sql.context.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xlc on 2018/4/1.
 */
@Service("testService")
public class TestServiceImpl implements TestService {
    @Autowired
    TestMapper testMapper;

    @Override
    public List<Integer> select() {
        return testMapper.select();
    }
}
