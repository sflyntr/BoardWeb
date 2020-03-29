package com.springbook.view.controller;

import com.springbook.biz.board.dao.BoardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteBoardController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 삭제 처리");
        BoardDAO boardDAO = new BoardDAO();

        boardDAO.deleteBoard(Integer.parseInt(request.getParameter("seq")));
        return "getBoardList.do";
    }
}
