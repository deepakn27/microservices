<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="menu.jsp" %>  
 
    <h3 style="color: red;">
    <c:if test="${message != null}"> 
      <c:out value="${message}"></c:out>
      </c:if> 
    </h3>
     <div>
     <c:if test="${userInfo != null}"> 
      <c:out value="${userInfo}"></c:out>
      </c:if> 
      </div>
</body>
</html>