package com.manji.service.inter;

import com.manji.pojo.User;
import com.manji.service.resultBean.UserLoginResultBean;

/**
 * Created by 杨港 on 2019/9/24.
 */
public interface UserService {
    public UserLoginResultBean UserLogin(User user);
    public boolean UpdatePwd(String username,String newpass);
}
