<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<c:choose>
    <c:when test="${sessionScope.login == null}">
        <a href="/api/v1/auth/login.do">로그인</a>
        <a href="/api/v1/auth/join.do">회원가입</a>
    </c:when>
    <c:otherwise>
        <a>${sessionScope.login.name}님 반갑니다</a>
        <a href="/api/v1/auth/logout.do">로그아웃</a>
    </c:otherwise>
</c:choose>
</body>
</html>
