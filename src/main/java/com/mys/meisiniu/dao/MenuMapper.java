package com.mys.meisiniu.dao;

import com.mys.meisiniu.model.Menu;

import java.util.List;

public interface MenuMapper {
     List<Menu> findTree(String usernmae);
}
