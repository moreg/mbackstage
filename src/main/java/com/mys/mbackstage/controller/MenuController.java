package com.mys.mbackstage.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mys.mbackstage.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Map;

@Controller

public class MenuController {
    @Autowired
    private MenuService menuService;

    @ResponseBody
    @RequestMapping(value = "/menu")
    public String menu(){
        String menu = JSON.toJSONString(menuService.findTree());
       return menu;
    }

    @RequestMapping(value = "/menulist")
    public String menuList(){
        return "menu";
    }
}
