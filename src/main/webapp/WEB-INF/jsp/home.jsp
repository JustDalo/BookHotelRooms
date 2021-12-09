<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.language != null ? sessionScope.language : 'ru'}" scope="session"/>
<fmt:bundle basename="home"/>
<!DOCTYPE html>
<html>

<head>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@600&display=swap" rel="stylesheet">
    <style>
        <%@include file="/assert/style.css" %>
        .intro {
            background: #000000 url("${pageContext.request.contextPath}/assert/img/indexBackground3.png") no-repeat center;
        }
    </style>
    <title>HomePage</title>
</head>

<body>
<jsp:include page="components/header.jsp"/>

<section class="intro">
    <div class="container">
        <h1 class="intro__title">
            FOREST<br>
            HOTEL
        </h1>
    </div>
</section>


<c:if test="${not empty requestScope.rooms}">
    <!--works-->
    <div class="works">
        <fmt:bundle basename="pagecontent" prefix="book.">
            <c:forEach var="room" items="${requestScope.rooms}">
                <a class="works__item"
                   href="${pageContext.request.contextPath}/controller?command=show-hotel-room&id=${room.id}">
                    <img class="works__photo"
                         src="${pageContext.request.contextPath}/assert/img/hotelRoomOceanView.jpg"
                         alt="">
                    <div class="works__content">
                        <div class="works__title">
                            <fmt:message key="room"/> ${room.id}
                        </div>
                        <div class="works__text">
                                ${room.price}$
                        </div>
                    </div>
                </a>
            </c:forEach>
        </fmt:bundle>
    </div>
    <!--/works-->
</c:if>

<jsp:include page="components/footer.jsp"/>
</body>
</html>
