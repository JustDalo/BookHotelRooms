<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jsp:include page="components/header.jsp"/>
<div id="mainContent">
    <h2><fmt:message key="login"/></h2>
    <c:choose>
        <c:when test="${not empty requestScope.error}">
            <p><fmt:message key="error"/> ${error} </p>
            <a href="${pageContext.request.contextPath}/controller?command=show_login"> <fmt:message
                    key="tryAgain"/> </a>
        </c:when>
        <c:otherwise>
            <form class="registerForm" action="${pageContext.request.contextPath}/controller?command=login"
                  method="post">
                <label for="fieldLogin"> <fmt:message key="login"/> </label><br>
                <input required type="text" id="fieldLogin" name="login"><br>
                <label for="fieldPassword"> <fmt:message key="password"/> </label><br>
                <input required type="password" id="fieldPassword" name="password"><br>
                <input type="submit" value="OK">
            </form>
        </c:otherwise>
    </c:choose>
</div>
<jsp:include page="components/footer.jsp"/>
</body>
</html>
