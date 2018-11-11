package com.profession.modules.position.controller;

import com.profession.commons.beans.Position;
import com.profession.commons.beans.PositionIntroduce;
import com.profession.commons.beans.PositionMarket;
import com.profession.commons.beans.PositionPO;
import com.profession.commons.utils.Constants;
import com.profession.modules.position.dto.PositionResp;
import com.profession.modules.position.param.PositionSearchParam;
import com.profession.modules.position.service.interfaces.PositionService;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author LEMON
 * @date 2018/7/3
 */
@RestController
@RequestMapping("/position")
@Api(value = "职位控制类PositionController")
public class PositionController {

    @Autowired
    private PositionService positionService;


    @PostMapping(value = "/findPositionByKey")
    public PositionResp<List<PositionPO>> findPositionByKey(@RequestBody PositionSearchParam searchParam){

        PositionResp<List<PositionPO>> resp = new PositionResp<List<PositionPO>>();

        try {
            searchParam.setStart((searchParam.getPageNumber() - 1) * searchParam.getPageSize());
            searchParam.setEnd(searchParam.getPageSize());
            List<PositionPO> resultList = positionService.findPositionByKey(searchParam);
            if(resultList != null && resultList.size() > 0){
                Integer total = positionService.getCountByKey(searchParam);
                resp.setTotal(total);
            }
            returnOnSuccess(resp);
            resp.setData(resultList);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            returnOnCatch(resp);
            return resp;
        }
    }


    /**
     * 添加position
     *@author LEMON
     */
    @PostMapping(value = "/savePosition")
    public PositionResp savePosition(@RequestBody Position position,@RequestBody PositionMarket positionMarket,@RequestBody PositionIntroduce positionIntroduce){

        PositionResp resp = new PositionResp();
        String positionName = position.getPositionName();
        //职位名称不能为空
        if(StringUtils.isBlank(positionName)){
            resp.setCode(Constants.RETURN_INFO_CODE_ERR1);
            resp.setDesc(Constants.RETURN_INFO_DESC_ERR1);
            return resp;
        }
        if (StringUtils.isNotBlank(positionMarket.getCityCode()) &&
                (positionMarket.getLocalAvgSalary() == null || positionMarket.getLocalDemand() == null)) {
            resp.setCode(Constants.RETURN_INFO_CODE_ERR2);
            resp.setDesc(Constants.RETURN_INFO_DESC_ERR2);
            return resp;

        }
        try {
            positionService.save(position,positionMarket,positionIntroduce);
        }catch (Exception e){
           returnOnCatch(resp);
            return resp;
        }
       returnOnSuccess(resp);
        return resp;
    }

    /**
     * 根据id 删除相关position信息
     *@author LEMON
     */
    @PostMapping(value = "/deleteById")
    public PositionResp deleteById(Long id){
        PositionResp resp = new PositionResp();
        try {
            Integer count = positionService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            returnOnCatch(resp);
            return resp;
        }
        returnOnSuccess(resp);
        return resp;
    }

    /**
     *更新信息
     * @return
     */
    @PostMapping("/updatePosition")
    public PositionResp updatePosition(@RequestBody Position position, @RequestBody PositionMarket positionMarket,
                                       PositionIntroduce positionIntroduce){
        String positionName = position.getPositionName();
        PositionResp resp = new PositionResp();
        try {

            if(position.getPositionId() == null && positionMarket.getPmId() == null && positionIntroduce.getId() == null){
                resp.setCode(Constants.RETURN_INFO_CODE_ERR3);
                resp.setDesc(Constants.RETURN_INFO_DESC_ERR3);
                return resp;
            }

            //职位名称不能为空
            if(StringUtils.isBlank(positionName)){
                resp.setCode(Constants.RETURN_INFO_CODE_ERR1);
                resp.setDesc(Constants.RETURN_INFO_DESC_ERR1);
                return resp;
            }
            if (StringUtils.isNotBlank(positionMarket.getCityCode()) &&
                    (positionMarket.getLocalAvgSalary() == null || positionMarket.getLocalDemand() == null)) {
                resp.setCode(Constants.RETURN_INFO_CODE_ERR2);
                resp.setDesc(Constants.RETURN_INFO_DESC_ERR2);
                return resp;

            }

            positionService.update(position,positionIntroduce,positionMarket);

        } catch (Exception e) {
            e.printStackTrace();
            returnOnCatch(resp);
            return resp;
        }
       returnOnSuccess(resp);
        return resp;
    }


    /**
     *根据id获取position
     */
    @PostMapping("/getPositionById")
    public PositionResp<Position> getPositionById(long id){
        PositionResp resp = new PositionResp<Position>();
        try {
            Position position = positionService.getPositionById(id);
            resp.setData(position);
        } catch (Exception e) {
            e.printStackTrace();
            returnOnCatch(resp);
            return resp;
        }
        returnOnSuccess(resp);
        return resp;
    }

    private void returnOnCatch(PositionResp resp){
        resp.setCode(Constants.RETURN_INFO_CODE_CATCH);
        resp.setDesc(Constants.RETURN_INFO_DESC_CATCH);
    }

    private void returnOnSuccess(PositionResp resp){
        resp.setCode(Constants.RETURN_INFO_CODE_SUCCESS);
        resp.setDesc(Constants.RETURN_INFO_DESC_SUCCESS);
    }
}
