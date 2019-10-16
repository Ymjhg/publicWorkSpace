package com.manji.service.resultBean;

/**
 * Created by 杨港 on 2019/9/26.
 */
public class DeleteNotesBean {
    private boolean isSucess;
    private String resultInfo;

    public boolean isSucess() {
        return isSucess;
    }

    public void setSucess(boolean sucess) {
        isSucess = sucess;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }
}
