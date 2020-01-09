package com.mys.meisiniu.service;

import com.github.pagehelper.PageInfo;
import com.mys.meisiniu.model.User;

import java.util.Set;

public interface UserService {
    PageInfo<User> findAllUser(int pageNum, int pageSize);
    public User findByUserName(String username);
    Set<String> findPermissionByUserName(String username);
    int countUser();
}
