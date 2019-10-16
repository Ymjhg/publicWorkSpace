package com.manji.service.resultBean;

import java.io.Serializable;

/**
 * Created by 杨港 on 2019/9/26.
 */
public class AddNotesBean  implements Serializable{
    private boolean isSucess;
    private String resultInfo;

    @Override
    public String toString() {
        return "{" +
                "isSucess:" + isSucess +
                ", resultInfo:'" + resultInfo + '\'' +
                '}';
    }

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
