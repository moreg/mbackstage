package com.mys.meisiniu.service;

import com.mys.meisiniu.model.Menu;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public interface MenuService {
    /*
     * 排序,根据order排序
     */
    public Comparator<Menu> order();
    public List<Menu> findTree(String username);
    public List<Menu> getChild(String id, List<Menu> allMenu);
    public List<Map> getMenuLsit();
}
