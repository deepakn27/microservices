<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="security"  uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 
       <%@include file="menu.jsp" %>    
       
      <h2>User Info Page</h2>
      <h3>Welcome :  <c:out value="${pageContext.request.userPrincipal.name}"></c:out></h3>
      <b>This is protected page!</b>  
       
      <br/><br/>
       
       <div>
     <c:if test="${userInfo != null}"> 
      <c:out value="${userInfo}"></c:out>
      </c:if> 
      </div>
      <br>
      <br>
      
	<div style="color: blue; margin: 10px 0px;">
		<security:authorize access="hasRole('ROLE_USER')">
    This text is only visible to a user
    <br/>
		</security:authorize>
		<security:authorize access="hasRole('ROLE_ADMIN')">
    This text is only visible to an admin
    <br/>
		</security:authorize>
	</div>
	
</body>
</html>