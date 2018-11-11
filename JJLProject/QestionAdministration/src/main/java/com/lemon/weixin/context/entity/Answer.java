package com.lemon.weixin.context.entity;

import java.io.Serializable;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/2/5
 */
public class Answer implements Serializable {

    private static final long serialVersionUID = 289492803989742203L;
    //主键id
    private Long id;
    //题目id
    private Long contextId;

    private String answerA;

    private int scoreA;

    private String answerB;

    private int scoreB;

    private String answerC;

    private int scoreC;

    private String answerD;

    private int scoreD;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContextId() {
        return contextId;
    }

    public void setContextId(Long contextId) {
        this.contextId = contextId;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public int getScoreA() {
        return scoreA;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public int getScoreB() {
        return scoreB;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public int getScoreC() {
        return scoreC;
    }

    public void setScoreC(int scoreC) {
        this.scoreC = scoreC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public int getScoreD() {
        return scoreD;
    }

    public void setScoreD(int scoreD) {
        this.scoreD = scoreD;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", contextId=" + contextId +
                ", answerA='" + answerA + '\'' +
                ", scoreA=" + scoreA +
                ", answerB='" + answerB + '\'' +
                ", scoreB=" + scoreB +
                ", answerC='" + answerC + '\'' +
                ", scoreC=" + scoreC +
                ", answerD='" + answerD + '\'' +
                ", scoreD=" + scoreD +
                '}';
    }
}
