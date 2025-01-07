<%--
  Created by IntelliJ IDEA.
  User: tiaal
  Date: 2025-01-07
  Time: 오후 6:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="/js/jquery-3.7.1.js"></script>

<head>
    <title>Title</title>
</head>
<body>
<div>
    <div>
        게시물 번호<input name="id" value="<c:out value="${notificationVO.id}"/>" readonly>
    </div>
    <div>
        조회수<input name="hits" value="<c:out value="${notificationVO.hits}"/>" readonly>
    </div>
    <div>
        제목<input name="title" value="<c:out value="${notificationVO.title}"/>" readonly>
    </div>
    <div>
        내용<textarea name="content" readonly><c:out value="${notificationVO.content}"/></textarea>
    </div>
    <div>
        작성자<input name="role" value="관리자" readonly>
    </div>
    <div>
        작성 날짜<input name="createdAt" value="<fmt:formatDate value="${notificationVO.createdAt}" pattern="YY-MM-dd HH:mm"/>" readonly>
    </div>
    <div>
        수정 날짜<input name="updatedAt" value="<fmt:formatDate value="${notificationVO.updatedAt}" pattern="YY-MM-dd HH:mm"/>" readonly>
    </div>
    <c:if test="${sessionScope.login.role == 'ADMIN'}">
    <button>
        <a href="/api/v1/notifications/modified.do?id=${notificationVO.id}">수정</a>
    </button>
    <button>
        <a href="/api/v1/notifications/delete.do?id=${notificationVO.id}">삭제</a>
    </button>
    </c:if>
    <button>
        <a href="/api/v1/notifications/list.do">목록</a>
    </button>
</div>
</body>
</html>
