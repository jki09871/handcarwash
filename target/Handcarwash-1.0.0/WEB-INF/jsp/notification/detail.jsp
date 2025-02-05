<%--
  Created by IntelliJ IDEA.
  User: tiaal
  Date: 2025-01-07
  Time: 오후 6:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/cmmn/header.jsp" %>
<script src="/js/jquery-3.7.1.js"></script>
<div class="notification-container">
    <div class="notification-item">
        <label for="id">게시물 번호</label>
        <input id="id" name="id" value="<c:out value='${notificationVO.id}'/>" readonly>
    </div>
    <div class="notification-item">
        <label for="hits">조회수</label>
        <input id="hits" name="hits" value="<c:out value='${notificationVO.hits}'/>" readonly>
    </div>
    <div class="notification-item">
        <label for="title">제목</label>
        <input id="title" name="title" value="<c:out value='${notificationVO.title}'/>" readonly>
    </div>
    <div class="notification-item">
        <label for="content">내용</label>
        <textarea id="content" name="content" readonly><c:out value='${notificationVO.content}'/></textarea>
    </div>
    <div class="notification-item">
        <label for="role">작성자</label>
        <input id="role" name="role" value="관리자" readonly>
    </div>
    <div class="notification-item">
        <label for="createdAt">작성 날짜</label>
        <input id="createdAt" name="createdAt" value="<fmt:formatDate value='${notificationVO.createdAt}' pattern='YY-MM-dd HH:mm'/>" readonly>
    </div>
    <div class="notification-item">
        <label for="updatedAt">수정 날짜</label>
        <input id="updatedAt" name="updatedAt" value="<fmt:formatDate value='${notificationVO.updatedAt}' pattern='YY-MM-dd HH:mm'/>" readonly>
    </div>
    <div class="notification-actions">
        <c:if test="${sessionScope.login.role == 'ADMIN'}">
            <button class="btn"><a href="/api/v1/notifications/modified.do?id=${notificationVO.id}&pageNo=${pageNo}">수정</a></button>
            <button class="btn"><a href="/api/v1/notifications/delete.do?id=${notificationVO.id}&pageNo=${pageNo}">삭제</a></button>
        </c:if>
        <button class="btn"><a href="/api/v1/notifications/list.do?pageNo=${pageNo}">목록</a></button>
    </div>
</div>

<%@ include file="/WEB-INF/jsp/cmmn/footer.jsp" %>

