package com.syuka.mapper;


import com.syuka.model.Hr;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface HrMapper {

    @Select("select * from hr where username=#{name}")
    Hr selectHr(@Param("name") String name);

}
