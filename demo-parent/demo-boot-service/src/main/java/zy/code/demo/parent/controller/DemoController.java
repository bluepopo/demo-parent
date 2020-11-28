package zy.code.demo.parent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import zy.code.demo.api.po.ExecutionInfoResult;
import zy.code.demo.dao.ExecutionInfoResultMapper;

import javax.annotation.Resource;
import java.math.BigInteger;

@RestController
@RequestMapping("demo")
public class DemoController {

    @Resource
    ExecutionInfoResultMapper executionInfoResultMapper;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam(value = "name", required = false) String name){


        ExecutionInfoResult executionInfoResult = executionInfoResultMapper.selectByPrimaryKey(1L);
        System.out.println(executionInfoResult);
        return "hello" + name;
    }
}
