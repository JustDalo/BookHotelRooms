<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.language != null ? sessionScope.language : 'ru'}" scope="session"/>
<fmt:bundle basename="pagecontent" prefix="footer.">

    <footer style="height: 200px; background-color: black; text-align: center; position: relative;">
        <a class="button" style=" color: white;position: absolute;top: 50%;"
           href="${pageContext.request.contextPath}/controller?command=home"> <fmt:message key="goToMain"/></a>
    </footer>
</fmt:bundle>
