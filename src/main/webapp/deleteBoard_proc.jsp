<%@page import="com.springbook.biz.board.dao.BoardDAO"%>
<%@page import="com.springbook.biz.board.command.BoardVO"%>
<%@page contentType="text/html; charset=EUC-KR"%>

<%
	// 1. ����� �Է� ���� ����
	String seq = request.getParameter("seq");

	// 2. DB ���� ó��
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.deleteBoard(Integer.parseInt(seq));

	// 3. ȭ�� �׺���̼�
	response.sendRedirect("getBoardList.jsp");
%>