package com.syuka.test01.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface User1Mapper {

    @Insert("insert into user(username,password) values(#{username},#{password});")
    public int addUser(@Param("username") String username, @Param("password") String password);
}
