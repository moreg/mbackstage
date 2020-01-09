package com.mys.meisiniu.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mys.meisiniu.model.Menu;
import com.mys.meisiniu.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

public class MenuController {
    @Autowired
    private MenuService menuService;

    @ResponseBody
    @RequestMapping(value = "/menu")
    public String menuList(HttpSession session){
        List<Menu> menu = menuService.findTree("user");
        //JSONObject json = JSON.parseObject(menu);
        session.setAttribute("muneList",menu);
       return menu.toString();
    }


}
