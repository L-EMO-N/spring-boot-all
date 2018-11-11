package com.profession.modules.community.controller;

import com.profession.modules.community.service.interfaces.DynamicService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dengjie0707 on 2018/7/1.
 */
@RestController
@RequestMapping("/dynamic")
public class DynamicController {
    @Autowired
    private DynamicService dynamicService;

    @ApiOperation(value = "查询动态数据", notes = "")
    @RequestMapping("/queryDynamic")
    public Object queryDynamic( String user) {
        return dynamicService.queryDynamic(user );
    }

}
