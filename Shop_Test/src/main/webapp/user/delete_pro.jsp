<%@page import="shop.dao.UserRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userDAO" class="shop.dao.UserRepository" />

<%
	String userId = request.getParameter("userId");	

	UserRepository userRepo = new UserRepository();
	int result = userRepo.delete(userId);

	String root = request.getContextPath();

	if(result > 0) {
		response.sendRedirect(root + "/user/complete.jsp?msg=3");
	} else {
		response.sendRedirect(root + "/user/update.jsp");
		out.println("<script>alert('회원 탈퇴 중 오류가 발생하였습니다');</script>");
	}
%>
