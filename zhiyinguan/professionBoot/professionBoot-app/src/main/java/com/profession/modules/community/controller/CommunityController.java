package com.profession.modules.community.controller;

import com.profession.modules.community.service.interfaces.CommunityService;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dengjie0707 on 2018/7/1.
 */
@RestController
@RequestMapping("/community")
public class CommunityController {
    private static final Logger logger = Logger.getLogger(CommunityController.class);

    @Autowired
    private CommunityService communityService;



}
