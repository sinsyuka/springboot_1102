package com.syuka.controller;


import com.syuka.controller.tool.FormResult;
import com.syuka.model.Hr;
import com.syuka.model.User;
import com.syuka.service.DepartmentService;
import com.syuka.service.HrService;
import com.syuka.test01.mapper.User1Mapper;
import com.syuka.test02.mapper.User2Mapper;
import com.syuka.utils.LogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@LogAnnotation(value = "log打印")
@RestController
public class TestController {

    @Autowired
    private HrService hrService;

    @Autowired
    private User1Mapper user1Mapper;

    @Autowired
    private User2Mapper user2Mapper;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("globalException")
    public int globalExceptionTest(int i) {
        int j = 100/i;
        return j;
    }

    @RequestMapping(value = "selectHr",method = RequestMethod.GET)
    public Object selectHr(@RequestParam("name") String name){
        Hr hr = hrService.selectHr(name);
        return hr;
    }

    @RequestMapping("querydep")
        public Object queryDepartment(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){

        return new FormResult(true,departmentService.query(pageNum,pageSize));

    }

    @RequestMapping("insertTest1")
    public Object insertUser1(String username ,String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user1Mapper.addUser(username,password);
    }

    @RequestMapping("/log")
    public Object logAnnotation(@RequestParam("name")String name) {
        return name;
    }
    @RequestMapping("insertTest2")
    public Object insertUser2(String username ,String password){
        return user2Mapper.addUser(username,password);
    }

    @ExceptionHandler
    public Object haha(Exception e){
        return new FormResult(false,"500",e.getMessage());
    }

}
