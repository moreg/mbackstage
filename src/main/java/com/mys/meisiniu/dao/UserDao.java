package com.mys.meisiniu.dao;

import com.mys.meisiniu.model.User;

import java.util.List;
import java.util.Set;

public interface UserDao {
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