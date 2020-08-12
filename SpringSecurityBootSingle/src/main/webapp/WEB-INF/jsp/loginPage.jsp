<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
  
         
  <div style="color:red;margin:10px 0px;">
       <c:if test="${not empty error}">
         Login Failed!!!<br />
         Reason :
          <c:out value="${error}"></c:out>
        </c:if>
      </div>
      
      <div style="color:red;margin:10px 0px;">
       <c:if test="${not empty logout}">
          <c:out value="${logout}"></c:out>
        </c:if>
      </div>
      
       <div style="color:red;margin:10px 0px;">
       <c:if test="${not empty maxsession}">
          <c:out value="${maxsession}"></c:out>
        </c:if>
      </div>
      
      <div style="color:red;margin:10px 0px;">
       <c:if test="${not empty invalidsession}">
          <c:out value="${invalidsession}"></c:out>
        </c:if>
      </div>
<h3>Enter user name and password:</h3>
      <form name='f' action="/userlogin" method='POST'>
         <table>
            <tr>
               <td>User:</td>
               <td><input type='text' name='username' value='<c:out value="${emailid}"></c:out>'></td>
            </tr>
            <tr>
               <td>Password:</td>
               <td><input type='password' name='password' /></td>
            </tr>
             <tr>
               <td>Keep Me Logged In</td>
               <td><input type="checkbox" name="remember-me" /></td>
            </tr>        
            <tr>
               <td><input name="submit" type="submit" value="submit" /></td>
            </tr>
         </table>
      </form>
</body>
</html>