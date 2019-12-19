package com.mys.mbackstage.dao;

import com.mys.mbackstage.model.Menu;

import java.util.List;

public interface MenuMapper {
     List<Menu> findTree();
}
