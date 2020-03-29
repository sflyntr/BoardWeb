<%@page import="com.springbook.biz.board.dao.BoardDAO"%>
<%@page import="com.springbook.biz.board.command.BoardVO"%>
<%@page contentType="text/html; charset=EUC-KR"%>

<%
	// 1. 사용자 입력 정보 추출
	String seq = request.getParameter("seq");

	// 2. DB 연동 처리
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.deleteBoard(Integer.parseInt(seq));

	// 3. 화면 네비게이션
	response.sendRedirect("getBoardList.jsp");
%>