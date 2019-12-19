package com.mys.mbackstage.service;

import com.github.pagehelper.PageInfo;
import com.mys.mbackstage.model.Permission;
import com.mys.mbackstage.model.Role;
import com.mys.mbackstage.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    PageInfo<User> findAllUser(int pageNum, int pageSize);
    public User findByUserName(String username);
    Set<String> findPermissionByUserName(String username);
    int countUser();
}
