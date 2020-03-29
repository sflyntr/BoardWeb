package com.springbook.view.board;

import com.springbook.biz.board.dao.BoardDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteBoardController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("Spring mvc 글 삭제 처리");

        BoardDAO boardDAO = new BoardDAO();
        boardDAO.deleteBoard(Integer.parseInt(request.getParameter("seq")));
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:getBoardList.do");
        return mav;
    }
}
