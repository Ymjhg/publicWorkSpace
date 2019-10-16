package com.manji.service.resultBean;

import com.manji.pojo.User;

/**
 * Created by 杨港 on 2019/9/24.
 */
public class UserLoginResultBean {
    private boolean success;
    private String resultInfo;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfor) {
        this.resultInfo = resultInfor;
    }
}
