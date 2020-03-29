package com.springbook.view.board;

import com.springbook.biz.board.command.BoardVO;
import com.springbook.biz.board.dao.BoardDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertBoardController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.println("Spring mvc 글 등록 처리");

        BoardDAO boardDAO = new BoardDAO();
        BoardVO board = new BoardVO();

        board.setTitle(request.getParameter("title"));
        board.setWriter(request.getParameter("writer"));
        board.setContent(request.getParameter("content"));

        boardDAO.insertBoard(board);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:getBoardList.do");
        return mav;
    }
}
