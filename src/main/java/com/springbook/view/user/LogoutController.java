package com.springbook.view.user;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("Spring mvc 로그아웃 처리");

        HttpSession session = request.getSession();
        session.invalidate();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login.jsp");
        return mav;
    }
}
