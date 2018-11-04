package com.syuka.service;

import com.syuka.mapper.HrMapper;
import com.syuka.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HrService {

    @Autowired
    private HrMapper hrMapper;

    public Hr selectHr(String name) {
        return hrMapper.selectHr( name);
    }
}
