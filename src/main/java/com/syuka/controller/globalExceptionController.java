package com.syuka.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class globalExceptionController {

    @RequestMapping("global")
    public Object globalTest(int i) {
        int j = 200/i;
        return j;
    }
}
