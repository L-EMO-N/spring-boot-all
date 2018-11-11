package com.lemon.position.controller;

import com.lemon.position.dto.PositionReps;
import com.lemon.position.entity.Position;
import com.lemon.position.entity.PositionIntroduce;
import com.lemon.position.entity.PositionMarket;
import com.lemon.position.entity.PositionPO;
import com.lemon.position.param.PositionSearchParam;
import com.lemon.position.service.PositionService;
import com.lemon.util.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author LEMON
 * @date 2018/6/12
 */
@Controller
@RequestMapping("position")
public class PositionController {

    @Autowired
    private PositionService positionService;



    @RequestMapping("/gotoAddPage")
    public String gotoAddPage(){

        return "positionAdd";
    }

    @RequestMapping(value = "/findPositionByKey")
    public String  findPositionByKey(PositionSearchParam searchParam,Model model){

        searchParam.setStart((searchParam.getPageNumber() - 1) * searchParam.getPageSize());
        searchParam.setEnd(searchParam.getPageSize());
        List<PositionPO> resultList = positionService.findPositionByKey(searchParam);
        if(resultList != null && resultList.size() > 0){
            Integer total = positionService.getCountByKey(searchParam);
            searchParam.setTotal(total);
        }
        model.addAttribute("searchParam ",searchParam);
        model.addAttribute("resultList",resultList);
        model.addAttribute("test","test");
        return "positionPage";
    }


    /**
     * 添加position
     *@author LEMON
    */
    @RequestMapping(value = "/savePosition")
    @ResponseBody
    public PositionReps savePosition(Position position,PositionMarket positionMarket,PositionIntroduce positionIntroduce, Model model){

        PositionReps resp = new PositionReps();
        String positionName = position.getPosition_name();
        //职位名称不能为空
        if(StringUtils.isBlank(positionName)){
            resp.setCode(Constants.RETURN_INFO_CODE_ERR1);
            resp.setDesc(Constants.RETURN_INFO_DESC_ERR1);
            return resp;
        }
        if (StringUtils.isNotBlank(positionMarket.getCity_code()) &&
                (positionMarket.getLocal_avg_salary() == null || positionMarket.getLocal_demand() == null)) {
            resp.setCode(Constants.RETURN_INFO_CODE_ERR2);
            resp.setDesc(Constants.RETURN_INFO_DESC_ERR2);
            return resp;

        }
        try {
            positionService.save(position,positionMarket,positionIntroduce);
        }catch (Exception e){
            resp.setCode(Constants.RETURN_INFO_CODE_CATCH);
            resp.setDesc(Constants.RETURN_INFO_DESC_CATCH);
            return resp;
        }
        resp.setCode(Constants.RETURN_INFO_CODE_SUCCESS);
        resp.setDesc(Constants.RETURN_INFO_DESC_SUCCESS);
        return resp;
    }

    /**
     * 根据id 删除相关position信息
     *@author LEMON
    */
    @RequestMapping(value = "/deleteById")
    public String deleteById(Long id){
        try {
            Integer count = positionService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return  "redirect:findPositionByKey";
        }
        return "redirect:findPositionByKey";
    }

    /**
     *更新信息
     * @return
     */
    @RequestMapping("/updatePosition")
    @ResponseBody
    public PositionReps updatePosition(Position position, PositionMarket positionMarket,
                                       PositionIntroduce positionIntroduce){
        String positionName = position.getPosition_name();
        PositionReps resp = new PositionReps();
        try {

            if(position.getPosition_id() == null && positionMarket.getPm_id() == null && positionIntroduce.getId() == null){
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
            if (StringUtils.isNotBlank(positionMarket.getCity_code()) &&
                    (positionMarket.getLocal_avg_salary() == null || positionMarket.getLocal_demand() == null)) {
                resp.setCode(Constants.RETURN_INFO_CODE_ERR2);
                resp.setDesc(Constants.RETURN_INFO_DESC_ERR2);
                return resp;

            }

            positionService.update(position,positionIntroduce,positionMarket);

        } catch (Exception e) {
            e.printStackTrace();
            resp.setCode(Constants.RETURN_INFO_CODE_CATCH);
            resp.setDesc(Constants.RETURN_INFO_DESC_CATCH);
            return resp;
        }
        resp.setCode(Constants.RETURN_INFO_CODE_SUCCESS);
        resp.setDesc(Constants.RETURN_INFO_DESC_SUCCESS);
        return resp;
    }


    /**
     *根据id获取position
     */
    @RequestMapping("/getPositionById")
    public String getPositionById(long id,Model model){
        Position position = positionService.getPositionById(id);
        model.addAttribute("position",position);
        return "positionEdit";
    }


}
