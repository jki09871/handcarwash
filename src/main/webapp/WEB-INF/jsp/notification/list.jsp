<%--
  Created by IntelliJ IDEA.
  User: tiaal
  Date: 2025-01-07
  Time: 오후 5:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/cmmn/header.jsp" %>
<script src="/js/jquery-3.7.1.js"></script>
<div class="table-container">
    <div class="table-header">
        <button class="btn write-btn"><a href="/api/v1/notifications/write.do">작성하기</a></button>
    </div>
    <table class="styled-table">
        <thead>
        <tr>
            <th style="text-align: center" >NO</th>
            <th>TITLE</th>
            <th>WRITER</th>
            <th>HITS</th>
            <th>CREATED_AT</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${notificationVO}" var="notification">
            <tr>
                <td style="text-align: center">${notification.id}</td>
                <td><a href="/api/v1/notifications/read.do?id=${notification.id}">${notification.title}</a></td>
                <td>관리자</td>
                <td>${notification.hits}</td>
                <td><fmt:formatDate value="${notification.createdAt}" pattern="yyyy-MM-dd"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<%@ include file="/WEB-INF/jsp/cmmn/footer.jsp" %>
