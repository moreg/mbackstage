package com.mys.mbackstage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mys.mbackstage.dao.UserMapper;
import com.mys.mbackstage.model.Permission;
import com.mys.mbackstage.model.Role;
import com.mys.mbackstage.model.User;
import com.mys.mbackstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service(value = "userService")
@SuppressWarnings("unchecked")
public class UserServiceImpl implements UserService {
    @Autowired

    private UserMapper userMapper;

    @Override
    public PageInfo<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> userDomains = userMapper.selectUsers();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }

    @Override
    @Cacheable(cacheNames = "user.service.username")
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public Set<String> findPermissionByUserName(String username) {
        return userMapper.findPermissionByUserName(username);
    }

    @Override
    public int countUser() {
        return userMapper.countUser();
    }
}
