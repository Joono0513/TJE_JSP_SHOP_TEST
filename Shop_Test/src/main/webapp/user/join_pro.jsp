<!-- 
	회원 가입 처리
 -->
<%@page import="shop.dao.UserRepository"%>
<%@page import="shop.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String birth = request.getParameter("birth");
	String mail = request.getParameter("mail");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");

	User user = new User();
	user.setId(id);
	user.setPassword(password);
	user.setName(name);
	user.setGender(gender);
	user.setBirth(birth);
	user.setMail(mail);
	user.setPhone(phone);
	user.setAddress(address);
	
	// 회원 정보 등록 요청
	UserRepository userDAO = new UserRepository();
	int result = userDAO.insert(user);
	
	// 회원 가입 성공
	if(result > 0) {
		response.sendRedirect("index.jsp");
		session.setAttribute("loginId", user.getId());
	}
	
	// 회원 가입 실패
	else {
		response.sendRedirect("join.jsp?msg=0");	// msg=0 은 회원가입 실패
	}
%>
    
    

    
    
    
    
    
    