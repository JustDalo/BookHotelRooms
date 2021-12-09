<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language != null ? sessionScope.language : 'ru'}" scope="session"/>
<fmt:bundle basename="pagecontent" prefix="room.">

    <html>
    <head>
        <title>Room</title>
        <style>
            <%@include file="/assert/style.css" %>
            body {
                text-align: center;
                background-color: black
            }

            form input {
                margin: 13px;
            }

            .roomInfo {
                border: 2px solid #D4D4D4; /* Ширина и цвет границ*/
                border-radius: 10px; /* Радиус границ*/
                box-shadow: 0 0 15px #A9A9A9; /* Размер и цвет тени блока*/
                padding: 20px;
                margin: 15px 200px;
            }

            div#mainContent {
                margin-top: 150px;
            }

            .intro {
                background: #000000 url("${pageContext.request.contextPath}/assert/img/indexBackground3.png") no-repeat center;
            }
        </style>
    </head>
    s
    <body>
    <jsp:include page="components/header.jsp"/>
    <div id="mainContent">
        <h2><fmt:message key="room"/> </h2>
        <img src="${pageContext.request.contextPath}/assert/img/hotelRoomOceanView.jpg"
             alt="">
        <div class="roomInfo">
            <p><fmt:message key="square"/>: ${requestScope.room.squareMeters}</p>
            <p><fmt:message key="adultsNumber"/>: ${requestScope.room.maxAdults}</p>
            <p><fmt:message key="childrenNumber"/>: ${requestScope.room.maxChildren}</p>
            <p><fmt:message key="price"/>: ${requestScope.room.price}</p>
        </div>
        <c:choose>
            <c:when test="${empty sessionScope.user}">
                <p> <fmt:message key="loginOrRegistr"/></p>
            </c:when>
            <c:otherwise>
                <c:if test="${sessionScope.role == 2}">
                    <a style="margin: 10px; color: darkseagreen;" class="button_book"
                       href="${pageContext.request.contextPath}/controller?command=show-book&id=${requestScope.room.id}"><fmt:message key="book"/> </a>
                </c:if>
            </c:otherwise>
        </c:choose>
    </div>
    <jsp:include page="components/footer.jsp"/>
    </body>
    </html>
</fmt:bundle>
