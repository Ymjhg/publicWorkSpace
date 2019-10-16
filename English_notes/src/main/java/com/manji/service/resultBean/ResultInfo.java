package com.manji.service.resultBean;

/**
 * Created by 杨港 on 2019/10/3.
 */
public class ResultInfo {
    public String resultInfo="测试测试";

    public ResultInfo() {

    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "resultInfo='" + resultInfo + '\'' +
                '}';
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }
}
