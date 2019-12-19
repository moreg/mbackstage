package com.mys.mbackstage.service;

import com.mys.mbackstage.model.Menu;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public interface MenuService {
    /*
     * 排序,根据order排序
     */
    public Comparator<Menu> order();
    public Map<String,Object> findTree();
    public List<Menu> getChild(String id, List<Menu> allMenu);
}
