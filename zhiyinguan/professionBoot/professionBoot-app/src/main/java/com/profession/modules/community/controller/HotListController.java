package com.profession.modules.community.controller;

import com.profession.commons.beans.CommunityQueryCriteria;
import com.profession.modules.community.service.interfaces.HotListService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dengjie0707 on 2018/7/1.
 */
@RestController
@RequestMapping("/hotlist")
public class HotListController {
    @Autowired
    private HotListService hotListService;

    @ApiOperation(value = "查询热榜数据", notes = "")
    @PostMapping("/queryHotList")
    public Object queryHotList(@RequestBody CommunityQueryCriteria c) {
        return hotListService.queryHotList(c );
    }

}
