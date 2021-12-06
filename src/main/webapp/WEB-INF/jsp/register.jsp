<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/30/2021
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <style>
        body {
            background: #000000;
        }
    </style>
</head>
<body>
<jsp:include page="components/header.jsp"/>
<div id="mainContent">
    <h2><fmt:message key="register"/></h2>
    <c:choose>
        <c:when test="${not empty requestScope.error}">
            <p><fmt:message key="error"/> ${error} </p>
            <a href="${pageContext.request.contextPath}/controller?command=show_register"> <fmt:message
                    key="tryAgain"/> </a>
        </c:when>
        <c:otherwise>
            <form class="registerForm" action="${pageContext.request.contextPath}/controller?command=register"
                  method="post">
                <label for="fieldLogin"> <fmt:message key="login"/> </label><br>
                <input required type="text" id="fieldLogin" name="login"><br>
                <label for="fieldPassword"> <fmt:message key="password"/> </label><br>
                <input required type="password" id="fieldPassword" name="password"><br>
                <label for="firstName"> <fmt:message key="first-name"/> </label><br>
                <input required type="text" id="firstName" name="first-name"><br>
                <label for="lastName"> <fmt:message key="last-name"/> </label><br>
                <input required type="text" id="lastName" name="last-name"><br>
                <input type="submit" value="OK">
            </form>
        </c:otherwise>
    </c:choose>
</div>
<jsp:include page="components/footer.jsp"/>
</body>
</html>
