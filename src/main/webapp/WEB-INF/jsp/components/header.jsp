<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<header class="header">
    <div class ="container">
        <div class = "header__inner">
            <div class = "header__logo">
                <img src="${pageContext.request.contextPath}/assert/img/hotelLogo.png" alt="logo">
            </div>

            <nav class = "nav">
                <a class = "nav__link" href="${pageContext.request.contextPath}/controller?command=show-register">Register</a>
                <a class = "nav__link" href = "#">Works</a>
                <a class = "nav__link" href = "#">Our Team</a>
                <a class = "nav__link" href = "#">Testimonials</a>
                <a class = "nav__link" href = "#">Download</a>
            </nav>
        </div>
    </div>
</header>
