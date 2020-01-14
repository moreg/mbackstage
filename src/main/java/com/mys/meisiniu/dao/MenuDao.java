package com.mys.meisiniu.dao;

import com.mys.meisiniu.model.Menu;

import java.util.List;
import java.util.Map;

public interface MenuDao {
     List<Menu> findTree(String usernmae);
     List<Menu> getMenuList();
}
