package com.matrix.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.matrix.demo.entity.User;
import com.matrix.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/list")
    public Object list() {

        List<User> userList = userService.getAll();
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", 0);
        obj.put("errmsg", "成功");
        obj.put("data", userList);
        return obj;
    }
}
