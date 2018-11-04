package com.syuka.mapper;

import com.syuka.model.Department;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DepartmentMapper {

    @Select("select * from department")
    List<Department> query();

}
