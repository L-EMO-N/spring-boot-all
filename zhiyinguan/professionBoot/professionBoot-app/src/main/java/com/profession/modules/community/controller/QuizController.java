package com.profession.modules.community.controller;

import com.profession.modules.community.service.interfaces.QuizService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dengjie0707 on 2018/7/1.
 */
@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @ApiOperation(value = "查询提问数据", notes = "")
    @RequestMapping("/queryQuiz")
    public Object queryQuiz( String user) {
        return quizService.queryQuiz(user );
    }

}
