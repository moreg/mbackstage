package com.mys.meisiniu.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mys.meisiniu.model.Menu;
import com.mys.meisiniu.service.MenuService;

import org.activiti.engine.impl.util.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;


    @RequestMapping(value = "/menujson")
    @ResponseBody
    public String menujson(HttpSession session){
        List<Map> menu = menuService.getMenuLsit();
        String json = JSON.toJSONString(menu);
        JSONObject jsonMenu = new JSONObject();
        JSONObject jsonMenu2 = new JSONObject();
        jsonMenu2.put("code",200);
        jsonMenu2.put("message","操作成功");
        jsonMenu.put("status",jsonMenu2);
        jsonMenu.put("data",json);
        System.out.println(jsonMenu);
        return jsonMenu.toString();
    }
    @RequestMapping(value = "/menuLsit")
    public String menuLsit(HttpSession session, Model model){
      //  String username = session.getAttribute;
        List<Menu> menu = menuService.findTree("user");
        System.out.println(menu);
        session.setAttribute("smenus",menu);
        model.addAttribute("menus",menu);
        model.addAttribute("abc","123456");
        return "/menu/sysMenu";
    }

}
