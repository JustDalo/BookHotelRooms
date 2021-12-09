<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language != null ? sessionScope.language : 'ru'}" scope="session"/>
<fmt:bundle basename="pagecontent" prefix="header.">

    <html>
    <head>
        <title>Register</title>
        <style>
            <%@include file="/assert/style.css" %>
            body {
                text-align: center;
                background-color: black
            }

            form input {
                margin: 13px;
            }

            div#mainContent {
                margin-top: 150px;
            }

            .intro {
                background: #000000 url("${pageContext.request.contextPath}/assert/img/indexBackground3.png") no-repeat center;
            }
        </style>
    </head>
    <body>
    <jsp:include page="components/header.jsp"/>
    <div id="mainContent">
        <h2 style="margin: 20px;"><fmt:message key="allBooks"/></h2>
        <c:if test="${not empty requestScope.books}">
            <div style="margin: 20px; border: #6c7279 ">
                <fmt:bundle basename="pagecontent" prefix="book.">
                    <c:forEach var="book" items="${requestScope.books}">
                        <br>
                        <p><a href="${pageContext.request.contextPath}/controller?command=show-room&id=${book.roomId}"><fmt:message key="room"/> ${book.roomId} </a>
                        </p>
                        <p><fmt:message key="checkIn"/>: ${book.checkIn}</p>
                        <p><fmt:message key="checkOut"/>: ${book.checkOut}</p>
                        <p><fmt:message key="adultsNumber"/>: ${book.adultsNumber}</p>
                        <p><fmt:message key="childrenNumber"/>: ${book.childrenNumber}</p>
                        <p><fmt:message key="userId"/>: ${book.userId}</p>

                    </c:forEach>
                </fmt:bundle>
            </div>
        </c:if>
    </div>
    <jsp:include page="components/footer.jsp"/>
    </body>
    </html>
</fmt:bundle>
