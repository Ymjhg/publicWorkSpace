package com.manji.filter;

import com.manji.ConstantDatas;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 杨港 on 2019/9/24.
 */
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();

        if (session == null || session.getAttribute(ConstantDatas.USER_NOW) == null) {
            request.setAttribute(ConstantDatas.RESULT_INFO,"用户为登录，请先登录！");
            response.sendRedirect("/index.jsp");
            return;
        } else {
            //这里表示正确，会去寻找下一个链，如果不存在，则进行正常的页面跳转
            chain.doFilter(request, response);
            return;
        }

    }

    public void destroy() {

    }
}
