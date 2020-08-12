<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="security"  uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DashBoard</title>
</head>
<body>
 <a href="<c:url value="/" />" >Home </a>
 
     | &nbsp;
 <a href="<c:url value="/dashboard" />" >DashBoard </a> 
  
  <security:authorize access="hasRole('ROLE_ADMIN')">
     | &nbsp;
  <a href="<c:url value="/admin" />" >Administrator </a>
    </security:authorize>
     | &nbsp;
     
  <c:if test="${pageContext.request.userPrincipal.name != null}">
   <a href="<c:url value="/logout" />" >Logout </a> 
   </c:if>    
</body>
</html>