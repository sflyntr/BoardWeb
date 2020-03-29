package com.springbook.view.controller;

import com.springbook.biz.board.command.BoardVO;
import com.springbook.biz.board.dao.BoardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateBoardController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 수정 처리");
        BoardDAO boardDAO = new BoardDAO();

        BoardVO board = new BoardVO();
        board.setSeq(Integer.parseInt(request.getParameter("seq")));
        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));

        boardDAO.updateBoard(board);

        return "getBoardList.do";

    }
}
