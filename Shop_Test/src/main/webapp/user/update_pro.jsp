<%@page import="shop.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userDAO" class="shop.dao.UserRepository" />
<%

	// 회원 정보 수정 처리
	String userId = request.getParameter("userId");
	String userName = request.getParameter("userName");
	String gender = request.getParameter("gender");
	String birth = request.getParameter("birth");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");
	
	User user = new User();
	
	user.setId("userId");
	user.setName("userName");
	user.setGender("gender");
	user.setBirth("birth");
	user.setMail("email");
	user.setPhone("phone");
	user.setAddress("address");
	
	
	
    int result = userDAO.update(user);
    if (result >0 ){
        response.sendRedirect("complete.jsp?msg=2");
    } else {
        response.sendRedirect("update.jsp");
    }

%>
