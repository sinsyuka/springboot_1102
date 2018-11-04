package com.syuka.test02.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface User2Mapper {
    @Insert("insert into user(username,password) values(#{username},#{password});")
    public int addUser(@Param("username") String name, @Param("password") String password);
}
