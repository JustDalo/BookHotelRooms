<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.language != null ? sessionScope.language : 'ru'}" scope="session"/>
<fmt:bundle basename="pagecontent" prefix="header.">
    <header class="header">
        <div class="container">
            <div class="header__inner">
                <div class="header__logo">
                    <img src="${pageContext.request.contextPath}/assert/img/hotelLogo.png" alt="logo">
                </div>

                <nav class="nav">
                    <a class="nav__link"
                       href="${pageContext.request.contextPath}/controller?command=home"><fmt:message
                            key="mainPage"/></a>
                    <c:choose>
                        <c:when test="${empty sessionScope.user}">
                            <a class="nav__link"
                               href="${pageContext.request.contextPath}/controller?command=show-register"><fmt:message
                                    key="register"/></a>
                            <a class="nav__link"
                               href="${pageContext.request.contextPath}/controller?command=show-login"><fmt:message
                                    key="login"/> </a>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${sessionScope.role == 2}">
                                    <a class="nav__link"
                                       href="${pageContext.request.contextPath}/controller?command=show-my-bookings"><fmt:message
                                            key="myBooks"/></a>
                                </c:when>
                                <c:otherwise>
                                    <a class="nav__link"
                                       href="${pageContext.request.contextPath}/controller?command=show-all-bookings"><fmt:message
                                            key="allBooks"/></a>
                                </c:otherwise>
                            </c:choose>
                            <a class="nav__link"
                               href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message
                                    key="exit"/></a>
                        </c:otherwise>
                    </c:choose>
                    <a class="nav__link locale" href="${pageContext.request.contextPath}/controller?${pageContext.request.queryString}&lang=ru">RU</a>
                    <a class="nav__link locale" href="${pageContext.request.contextPath}/controller?${pageContext.request.queryString}&lang=en">EN</a>
                </nav>
            </div>
        </div>
    </header>
</fmt:bundle>