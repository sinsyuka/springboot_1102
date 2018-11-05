package com.syuka.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syuka.mapper.DepartmentMapper;
import com.syuka.model.Department;
import com.syuka.utils.ServicePageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    @ServicePageResult
    public Object query(int pageNum, int pageSize) {

/*
        // 开启分页插件,放在查询语句上面
        PageHelper.startPage(pageNum,pageSize);
*/

        List<Department> departments = departmentMapper.query();

        // 封装分页之后的数据
//        PageInfo<Department> pageInfoDepartment = new PageInfo<Department>(departments);

        return departments;

    }
}
