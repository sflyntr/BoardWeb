package com.springbook.view.controller;

import com.springbook.biz.board.dao.BoardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetBoardListController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 목록 검색 처리");

        BoardDAO boardDAO = new BoardDAO();

        HttpSession session = request.getSession();
        session.setAttribute("boardList", boardDAO.getBoardList());

        return "getBoardList";
    }
}
