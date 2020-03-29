package com.springbook.view.controller;

import com.springbook.biz.board.command.BoardVO;
import com.springbook.biz.board.dao.BoardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertBoardController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        BoardDAO boardDAO = new BoardDAO();
        BoardVO board = new BoardVO();

        board.setTitle(request.getParameter("title"));
        board.setWriter(request.getParameter("writer"));
        board.setContent(request.getParameter("content"));

        boardDAO.insertBoard(board);

        return "getBoardList.do";
    }
}
