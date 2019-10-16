package com.manji.service.impl;

import com.manji.dao.UserDao;
import com.manji.pojo.User;
import com.manji.service.inter.UserService;
import com.manji.service.resultBean.UserLoginResultBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 杨港 on 2019/9/24.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public UserLoginResultBean UserLogin(User user) {
        UserLoginResultBean userLoginResultBean=new UserLoginResultBean();
        try{
            User userNow = userDao.UserLogin(user);
            if (userNow==null) {
                userLoginResultBean.setSuccess(false);
                userLoginResultBean.setResultInfo("用户名或密码错误，请重试！");
            }else{
                userLoginResultBean.setSuccess(true);
                userLoginResultBean.setUser(userNow);
                userLoginResultBean.setResultInfo("登录成功！");
            }
        }catch(Exception e){
            userLoginResultBean.setSuccess(false);
            userLoginResultBean.setResultInfo("服务器错误，请重试！");
            return userLoginResultBean;
        }
        return userLoginResultBean;
    }

    public boolean UpdatePwd(String username, String newpass) {
        boolean b;
        try{
            b = userDao.UpdatePwd(username, newpass);
        }catch(Exception e){
            e.printStackTrace();
            b=false;
        }
        return b;
    }
}
