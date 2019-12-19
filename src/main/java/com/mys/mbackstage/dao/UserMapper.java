package com.mys.mbackstage.dao;

import com.mys.mbackstage.model.Permission;
import com.mys.mbackstage.model.Role;
import com.mys.mbackstage.model.User;

import java.util.List;
import java.util.Set;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectUsers();

    User findByUserName(String username);

    Set<String> findPermissionByUserName(String username);

    int countUser();
}