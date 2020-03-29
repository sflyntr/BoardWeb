package com.springbook.view.board;

import com.springbook.biz.board.command.BoardVO;
import com.springbook.biz.board.dao.BoardDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateBoardController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.println("Spring mvc 글 수정 처리");

        BoardDAO boardDAO = new BoardDAO();

        BoardVO board = new BoardVO();
        board.setSeq(Integer.parseInt(request.getParameter("seq")));
        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));

        boardDAO.updateBoard(board);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:getBoardList.do");
        return mav;
    }
}
