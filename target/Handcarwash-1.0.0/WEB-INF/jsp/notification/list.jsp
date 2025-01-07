<%--
  Created by IntelliJ IDEA.
  User: tiaal
  Date: 2025-01-07
  Time: 오후 5:39
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
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>TITLE</th>
                <th>WRITER</th>
                <th>HITS</th>
                <th>CREATED_AT</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${notificationVO}" var="notification">
                <tr>
                    <td>${notification.id}</td>
                    <td><a href="/api/v1/notifications/read.do?id=${notification.id}">${notification.title}</a></td>
                    <td>관리자</td>
                    <td>${notification.hits}</td>
                    <td><fmt:formatDate value="${notification.createdAt}" pattern="yyyy-MM-dd"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
