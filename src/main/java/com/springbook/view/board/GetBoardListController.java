package com.springbook.view.board;

import com.springbook.biz.board.dao.BoardDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetBoardListController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("Spring mvc 글 목록 검색 처리");

        BoardDAO boardDAO = new BoardDAO();
        ModelAndView mav = new ModelAndView();
        mav.addObject("boardList", boardDAO.getBoardList());
        mav.setViewName("getBoardList");
        return mav;
    }
}
