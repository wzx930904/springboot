package com.shsxt.controller;

import com.shsxt.model.User;
import com.shsxt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;
    private static Logger log = LoggerFactory.getLogger(UserController.class);
    @RequestMapping("list")
    public String list(Model model) {
        log.debug("这是一个debug日志");
        List<User> users = userService.find();
        model.addAttribute("users",users);
        return "user";
    }

    @RequestMapping("find/{id}")
    @ResponseBody
    public User findById(@PathVariable Integer id) {
        User user = userService.findById(id);
        return user;
    }
}
