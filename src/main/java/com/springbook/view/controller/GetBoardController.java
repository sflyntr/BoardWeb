package com.springbook.view.controller;

import com.springbook.biz.board.dao.BoardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetBoardController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 상세 조회 처리");
        BoardDAO boardDAO = new BoardDAO();

        HttpSession session = request.getSession();
        session.setAttribute("board", boardDAO.getBoard(Integer.parseInt(request.getParameter("seq"))));

        return "getBoard";

    }
}
