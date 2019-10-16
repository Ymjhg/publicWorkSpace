package com.manji.controller;

import com.manji.ConstantDatas;
import com.manji.pojo.User;
import com.manji.service.inter.UserService;
import com.manji.service.resultBean.UserLoginResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by 杨港 on 2019/9/24.
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/UserLogin")
    public String UserLogin(User user, Model model, HttpSession session){
        if (user.getUsername()==null ||user.getUserpwd()==null) {
            model.addAttribute(ConstantDatas.RESULT_INFO,"用户未登录，请先登录！");
            return "UserLogin";
        }
        user.setUsername(user.getUsername().trim());
        user.setUserpwd(user.getUserpwd().trim());
        UserLoginResultBean userLoginResultBean = userService.UserLogin(user);
        model.addAttribute(ConstantDatas.RESULT_INFO,userLoginResultBean.getResultInfo());
        if (userLoginResultBean.isSuccess()) {
            session.setAttribute(ConstantDatas.USER_NOW,userLoginResultBean.getUser());
            return "LexiconCenter";
        }else{
            return "UserLogin";
        }
    }

    @RequestMapping("/safe/UpdatePwd")
    public String UpdatePwd(String mpass,String newpass,String renewpass,Model model, HttpSession session){
        User userNow = (User) session.getAttribute(ConstantDatas.USER_NOW);
        if (userNow==null) {
            model.addAttribute(ConstantDatas.RESULT_INFO,"用户超时，请重新登录");
            return "UserLogin";
        }
        if (!mpass.equals(userNow.getUserpwd())) {
            model.addAttribute(ConstantDatas.UPDATE_PWD_MSG,"原始密码输入错误");
        }else if (!newpass.equals(renewpass)) {
            model.addAttribute(ConstantDatas.UPDATE_PWD_MSG,"两次新密码输入不一致");
        }else{
            boolean b = userService.UpdatePwd(userNow.getUsername(), newpass);
            if (b){
                model.addAttribute(ConstantDatas.UPDATE_PWD_MSG,"修改成功");
            }else{
                model.addAttribute(ConstantDatas.UPDATE_PWD_MSG,"修改失败，请重试");
            }
        }
        return "UpdatePwd";
    }
}
