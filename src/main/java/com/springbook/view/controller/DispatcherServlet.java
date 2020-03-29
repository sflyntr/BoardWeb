package com.springbook.view.controller;

import com.springbook.biz.board.command.BoardVO;
import com.springbook.biz.board.dao.BoardDAO;
import com.springbook.biz.user.command.UserVO;
import com.springbook.biz.user.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class DispatcherServlet extends HttpServlet {
    private static final long serailVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));
        System.out.println(path);

        if (path.equals("/login.do")) {
            System.out.println("로그인 처리");
            // 1. 사용자 입력 정보 추출
            String id = request.getParameter("id");
            String password = request.getParameter("password");

            // 2. DB 연동 처리
            UserVO vo = new UserVO();
            vo.setId(id);
            vo.setPassword(password);
            UserDAO userDAO = new UserDAO();
            UserVO user = userDAO.getUser(vo);

            // 3. 화면 네비게이션
            if (user != null) {
                response.sendRedirect("getBoardList.do");
            } else {
                response.sendRedirect("login.jsp");
            }
        } else if (path.equals("/logout.do")) {
            System.out.println("로그아웃 처리");

            // 1. 브라우저와 연결된 세션 객체를 강제 종료한다.
            HttpSession session = request.getSession();
            session.invalidate();
            // 2. 세션 종료 후, 메인 화면으로 이동한다.
            response.sendRedirect("login.jsp");
        } else if (path.equals("/insertBoard.do")) {
            System.out.println("글 등록 처리");

            // 1. 사용자 입력 정보 추출
            request.setCharacterEncoding("UTF-8");
            String title = request.getParameter("title");
            String writer = request.getParameter("writer");
            String content = request.getParameter("content");

            // 2. DB 연동 처리
            BoardVO vo = new BoardVO();
            vo.setTitle(title);
            vo.setWriter(writer);
            vo.setContent(content);
            BoardDAO boardDAO = new BoardDAO();
            boardDAO.insertBoard(vo);

            // 3. 화면 네비게이션
            response.sendRedirect("getBoardList.do");
        } else if (path.equals("/updateBoard.do")) {
            System.out.println("글 수정 처리");

            // 1. 사용자 입력 정보 추출
            request.setCharacterEncoding("UTF-8");
            String title = request.getParameter("title");
            String writer = request.getParameter("writer");
            String content = request.getParameter("content");

            // 2. DB 연동 처리
            BoardVO vo = new BoardVO();
            vo.setTitle(title);
            vo.setWriter(writer);
            vo.setContent(content);
            BoardDAO boardDAO = new BoardDAO();
            boardDAO.updateBoard(vo);

            // 3. 화면 네비게이션
            response.sendRedirect("getBoardList.do");

        } else if (path.equals("/deleteBoard.do")) {
            System.out.println("글 삭제 처리");
            // 1. 사용자 입력 정보 추출
            String seq = request.getParameter("seq");

            // 2. DB 연동 처리
            BoardDAO boardDAO = new BoardDAO();
            boardDAO.deleteBoard(Integer.parseInt(seq));

            // 3. 화면 네비게이션
            response.sendRedirect("getBoardList.do");

        } else if (path.equals("/getBoard.do")) {
            System.out.println("글 상세 조회 처리");
            // 1. 검색할 게시글 번호 추출
            String seq = request.getParameter("seq");

            // 2. DB 연동 처리
            BoardDAO boardDAO = new BoardDAO();
            BoardVO board = boardDAO.getBoard(Integer.parseInt(seq));

            // 3. 응답 화면 구성
            HttpSession session = request.getSession();
            session.setAttribute("board", board);
            response.sendRedirect("getBoard.jsp");

        } else if (path.equals("/getBoardList.do")) {
            System.out.println("글 목록 검색 처리");
            // 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
            // 2. DB 연동 처리
            BoardDAO boardDAO = new BoardDAO();
            List<BoardVO> boardList = boardDAO.getBoardList();

            // 3. 응답 화면 구성
            HttpSession session = request.getSession();
            session.setAttribute("boardList", boardList);
            response.sendRedirect("getBoardList.jsp");
        }

    }
}
