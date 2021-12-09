<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<fmt:setLocale value="${sessionScope.language != null ? sessionScope.language : 'ru'}" scope="session"/>
<fmt:bundle basename="pagecontent" prefix="register.">

    <html>
    <head>
        <title>Register</title>
        <style>
            <%@include file="/assert/style.css" %>
            body{
                text-align: center;
                background-color: black
            }
            form input{
                margin: 13px;
            }
            div#mainContent{
                margin-top: 150px;
            }
            .intro {
                background: #000000 url("${pageContext.request.contextPath}/assert/img/indexBackground3.png") no-repeat center;
            }
        </style>
    </head>s
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
                    <label for="firstName"> <fmt:message key="firstName"/> </label><br>
                    <input required type="text" id="firstName" name="first-name"><br>
                    <label for="lastName"> <fmt:message key="secondName"/> </label><br>
                    <input required type="text" id="lastName" name="last-name"><br>
                    <input type="submit" value="OK">
                </form>
            </c:otherwise>
        </c:choose>
    </div>
    <jsp:include page="components/footer.jsp"/>
    </body>
    </html>
</fmt:bundle>
