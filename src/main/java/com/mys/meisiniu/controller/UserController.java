package com.mys.meisiniu.controller;

import com.github.pagehelper.PageInfo;
import com.mys.meisiniu.model.User;
import com.mys.meisiniu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userList")
    public String userList(){
        return "/user/userList";
    }
    @RequestMapping("/userAdd")
    public String userAdd(){
        return "/user/userAdd";
    }
    @RequestMapping("/userStatistics")
    public String userStatistics(){
        return "/user/userStatistics";
    }
    @RequestMapping(value = "/userJson")
    @ResponseBody
    public PageInfo<User> userJson(HttpServletRequest request, HttpServletResponse response, Map map,Integer currentPage,Integer pageSize) {
        PageInfo<User> pageInfo = userService.findAllUser(currentPage,pageSize);
        return pageInfo;
    }


}
