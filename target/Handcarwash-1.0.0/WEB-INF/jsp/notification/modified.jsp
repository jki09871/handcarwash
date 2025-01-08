<%--
  Created by IntelliJ IDEA.
  User: tiaal
  Date: 2025-01-07
  Time: 오후 6:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/cmmn/header.jsp" %>
<script src="/js/jquery-3.7.1.js"></script>
<div class="notification-container">
    <form action="/api/v1/notifications/modified.do" method="post" id="modify">
        <input type="hidden" name="id" id="id" value="${notificationVO.id}">

        <!-- 제목 입력 -->
        <div class="notification-item">
            <label for="title">제목</label>
            <input id="title" name="title" value="<c:out value='${notificationVO.title}'/>">
        </div>

        <!-- 내용 입력 -->
        <div class="notification-item">
            <label for="content">내용</label>
            <textarea id="content" name="content"><c:out value='${notificationVO.content}'/></textarea>
        </div>

        <!-- 버튼 영역 -->
        <div class="notification-actions">
            <c:if test="${sessionScope.login.role == 'ADMIN'}">
                <button type="button" class="btn" onclick="fnDynamic('M')">수정</button>
                <button type="button" class="btn" onclick="fnDynamic('L')">목록</button>
                <button type="button" class="btn" onclick="fnDynamic('R')">취소</button>
            </c:if>
        </div>
    </form>
</div>

<%@ include file="/WEB-INF/jsp/cmmn/footer.jsp" %>

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