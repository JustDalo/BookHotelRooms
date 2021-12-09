<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language != null ? sessionScope.language : 'ru'}" scope="session"/>
<fmt:bundle basename="pagecontent" prefix="book.">
    <html>
    <head>
        <title>Booking</title>
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
        <h2>Booking</h2>
        <c:choose>
            <c:when test="${not empty requestScope.error}">
                <p><fmt:message key="error"/> ${requestScope.error} </p>
                <a href="${pageContext.request.contextPath}/controller?command=show-book&id=${requestScope.room.id}"><fmt:message key="tryAgain"/> </a>
            </c:when>
            <c:otherwise>
                <p> <fmt:message key="room" />${requestScope.room.id}</p>
                <p> <fmt:message key="room.square"/> ${requestScope.room.squareMeters}</p>
                <p> <fmt:message key="room.price"/> ${requestScope.room.price}$</p>
                <form class="bookForm"
                      action="${pageContext.request.contextPath}/controller?command=book&id=${requestScope.room.id}"
                      method="post">
                    <label for="fieldStartDay"> <fmt:message key="checkIn"/></label><br>
                    <input type="date" required id="fieldStartDay" name="startDay"><br>
                    <label for="fieldLastDay"> <fmt:message key="checkOut"/> </label><br>
                    <input type="date" required id="fieldLastDay" name="lastDay"><br>
                    <label for="fieldAdultsCount"> <fmt:message key="adultsNumber"/></label><br>
                    <input type="number" min="0" max="${requestScope.room.maxAdults}" required id="fieldAdultsCount"
                           name="adultsCount"><br>
                    <label for="fieldChildrenCount"> <fmt:message key="childrenNumber"/> </label><br>
                    <input type="number" min="0" max="${requestScope.room.maxChildren}" required id="fieldChildrenCount"
                           name="childrenCount"><br>
                    <input type="submit" value="OK">
                </form>
            </c:otherwise>
        </c:choose>
    </div>
    <jsp:include page="components/footer.jsp"/>
    </body>
    </html>
</fmt:bundle>