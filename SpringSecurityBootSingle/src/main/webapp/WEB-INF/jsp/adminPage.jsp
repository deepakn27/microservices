<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${title}"/></title>
</head>
<body>
   <%@include file="menu.jsp" %>   
       
      <h2>Admin Page</h2>
      <h3>Welcome :
         <c:out value="${pageContext.request.userPrincipal.name}"></c:out>
      </h3>
      <b>This is protected page!</b>  
       
      <br/><br/>
      <c:if test="${userInfo != null}"> 
      <c:out value="${userInfo}"></c:out>
      </c:if> 
      
       
   </body>
</body>
</html>