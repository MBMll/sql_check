package com.sql.web;

import com.sql.context.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xlc on 2018/4/1.
 */
@RestController
@RequestMapping(value = "test")
public class TestController {
    @Autowired
    TestService testService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Integer> list() {
        return testService.select();
    }
}
