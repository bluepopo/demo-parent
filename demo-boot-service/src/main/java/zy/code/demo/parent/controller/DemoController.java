package zy.code.demo.parent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import zy.code.demo.api.po.User;
import zy.code.demo.api.po.UserInfo;
import zy.code.demo.common.util.MyResult;
import zy.code.demo.common.util.MyResultUtils;
import zy.code.demo.dao.UserInfoMapper;
import zy.code.demo.parent.mail.MailService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("demo")
public class DemoController {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Autowired
    MailService mailService;

    @RequestMapping("/userinfo")
    @ResponseBody
    public MyResult hello(@RequestParam(value = "name", required = false) String name){

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(1L);

        MyResult<UserInfo> myResult = MyResultUtils.wrapSuccess(userInfo);

        return myResult;
    }


    @RequestMapping("/sendmail")
    @ResponseBody
    public MyResult mail() {

        //收件人列表

        List<String> receiveList = new ArrayList<>();
        receiveList.add("934180574@qq.com");
        receiveList.add("574917462@qq.com");

        //抄送人列表
        List<String> ccMailList = null;

        String Subject = "邮件标题";

        //模板的实际参数
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(10L);
        user.setAge(22);
        user.setName("zy");
        user.setSex("女");
        user.setPhone("123455");
        user.setTime(System.currentTimeMillis());
        users.add(user);
        users.add(user);
        users.add(user);
        //模板名
        String templateName = "user";



        MyResult myResult = mailService.sendTempMail(receiveList, ccMailList, Subject, users, templateName);


        return myResult;


    }

}
