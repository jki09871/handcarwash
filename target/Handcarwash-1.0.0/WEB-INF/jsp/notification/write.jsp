<%--
  Created by IntelliJ IDEA.
  User: tiaal
  Date: 2025-01-07
  Time: 오후 4:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/cmmn/header.jsp" %>
<script src="/js/jquery-3.7.1.js"></script>
<div class="notification-container">
    <form action="/api/v1/notifications/write.do" method="post" name="form" class="styled-form">
        <div class="notification-item">
            <label for="title">제목</label>
            <input type="text" id="title" name="title" placeholder="제목" class="custom-input">
        </div>
        <div class="notification-item">
            <label for="content">내용</label>
            <textarea id="content" name="content" cols="30" rows="10" placeholder="내용을 입력하세요" class="custom-input"></textarea>
        </div>
        <div class="notification-actions">
            <button type="submit" class="btn">작성</button>
        </div>
    </form>
</div>
<%@ include file="/WEB-INF/jsp/cmmn/footer.jsp" %>

