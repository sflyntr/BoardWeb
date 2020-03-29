package com.springbook.view.user;

import com.springbook.biz.user.command.UserVO;
import com.springbook.biz.user.dao.UserDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("Spring MVC 로그인 처리");

        UserVO vo = new UserVO();
        vo.setId(request.getParameter("id"));
        vo.setPassword(request.getParameter("password"));

        UserDAO userDAO = new UserDAO();
        UserVO user = userDAO.getUser(vo);

        ModelAndView mav = new ModelAndView();
        if (user != null) {
            mav.setViewName("redirect:getBoardList.do");
        } else {
            mav.setViewName("redirect:login.jsp");
        }
        return mav;
    }
}
