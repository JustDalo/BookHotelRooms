<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'ru'}"/>
<fmt:bundle basename="labels"/>
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

<!--works-->
<div class="works">
    <div class="works__item">
        <img class="works__photo" src="../../assert/img/hotelRoomOceanView.jpg" alt="">
        <div class="works__content">
            <div class="works__title">
                project name
            </div>
            <div class="works__text">
                User Interface Design
            </div>
        </div>
    </div>
    <div class="works__item">
        <img class="works__photo" src="img/Album/1_2.jpg" alt="">
        <div class="works__content">
            <div class="works__title">
                project name
            </div>
            <div class="works__text">
                User Interface Design
            </div>
        </div>
    </div>
    <div class="works__item">
        <img class="works__photo" src="img/Album/1_3.jpg" alt="">
        <div class="works__content">
            <div class="works__title">
                project name
            </div>
            <div class="works__text">
                User Interface Design
            </div>
        </div>
    </div>
    <div class="works__item">
        <img class="works__photo" src="img/Album/1_4.jpg" alt="">
        <div class="works__content">
            <div class="works__title">
                project name
            </div>
            <div class="works__text">
                User Interface Design
            </div>
        </div>
    </div>
    <div class="works__item">
        <img class="works__photo" src="img/Album/2_1.jpg" alt="">
        <div class="works__content">
            <div class="works__title">
                project name
            </div>
            <div class="works__text">
                User Interface Design
            </div>
        </div>
    </div>
    <div class="works__item">
        <img class="works__photo" src="img/Album/2_2.jpg" alt="">
        <div class="works__content">
            <div class="works__title">
                project name
            </div>
            <div class="works__text">
                User Interface Design
            </div>
        </div>
    </div>
    <div class="works__item">
        <img class="works__photo" src="img/Album/2_3.jpg" alt="">
        <div class="works__content">
            <div class="works__title">
                project name
            </div>
            <div class="works__text">
                User Interface Design
            </div>
        </div>
    </div>
    <div class="works__item">
        <img class="works__photo" src="img/Album/2_4.jpg" alt="">
        <div class="works__content">
            <div class="works__title">
                project name
            </div>
            <div class="works__text">
                User Interface Design
            </div>
        </div>
    </div>
</div> <!--/works-->
<jsp:include page="components/footer.jsp"/>
</body>
</html>
