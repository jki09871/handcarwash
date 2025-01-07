<%--
  Created by IntelliJ IDEA.
  User: tiaal
  Date: 2025-01-07
  Time: 오후 4:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="/js/jquery-3.7.1.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/api/v1/notifications/write.do" method="post" name="form">
        <input type="text" name="title" placeholder="제목">
        <textarea name="content" cols="30" rows="10" placeholder="내용을 입력하세요"></textarea>
        <input type="submit" placeholder="작성">
    </form>
</body>
</html>
