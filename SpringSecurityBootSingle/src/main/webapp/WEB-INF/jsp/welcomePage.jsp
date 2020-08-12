<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${title}"/></title>
</head>
<body>
     <%@include file="menu.jsp" %>   
  <h2>Message : <c:out value="${message}"/></h2>
</body>
</html>