<%--
  Created by IntelliJ IDEA.
  User: tiaal
  Date: 2025-01-07
  Time: 오후 6:23
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
<div>
    <form action="/api/v1/notifications/modified.do" method="post" id="modify">
        <input type="hidden" name="id" id="id" value="${notificationVO.id}">
        <div>
            제목<input name="title" value="<c:out value="${notificationVO.title}"/>" >
        </div>
        <div>
            내용<textarea name="content" ><c:out value="${notificationVO.content}"/></textarea>
        </div>
        <c:if test="${sessionScope.login.role == 'ADMIN'}">
            <button onclick="fnDynamic('M')">수정</button>
            <button onclick="fnDynamic('L')">목록</button>
            <button onclick="fnDynamic('R')">취소</button>
        </c:if>
    </form>
</div>
</body>
</html>
<script>
    let form = $('#modify');
    let url = '';
    let method = '';
       function fnDynamic(se) {

           switch (se) {
               case 'M' :
                   const isConfirm = confirm("수정하시겠습니까?");
                   if (isConfirm){
                       alert("수정되었습니다.");
                       url = '/api/v1/notifications/modified.do';
                       method = 'post';
                       break;
                   } else {
                       alert("수정이 취소 되었습니다.");
                       break;
                   }
               case 'L' :
                   url = '/api/v1/notifications/list.do';
                   method = 'get';
                   break;
               default :
                   history.back(); // 이전 페이지로 이동
                   return; // 이후 코드 실행 방지
           }
           form.attr('action', url);
           form.attr('method', method);
           form.submit();
       }
</script>