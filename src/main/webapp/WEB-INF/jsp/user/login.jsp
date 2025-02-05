<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/cmmn/header.jsp" %>
<div class="about d-flex justify-content-center align-items-center custom-form-wrapper">
    <div class="custom-form-container">
        <form id="loginForm" method="post" action="/api/v1/auth/login.do" class="custom-form text-center">
            <input type="hidden" name="toUrl" value="${param.toUrl}">
            <h2 class="form-title">Login</h2>
            <div class="form-group">
                <label for="email" class="form-label">Email</label>
                <input type="text" id="email" name="email" value="${cookie.rememberId.value}"  required autocomplete="off" class="form-control custom-input">
            </div>
            <div class="form-group">
                <label for="password" class="form-label">Password</label>
                <input type="password" id="password" name="password" required autocomplete="off" class="form-control custom-input">
            </div>
            <div class="form-group">
                <label><input type="checkbox" name="rememberId"${empty cookie.rememberId.value ? "":"checked" }> 아이디 기억</label>
            </div>
            <div class="form-actions">
                <button type="submit" class="btn custom-btn">Login</button>
            </div>
            <div class="form-actions">
                <a href="/api/v1/auth/join.do" class="btn custom-link-btn">회원가입</a>
            </div>
        </form>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/cmmn/footer.jsp" %>
<!-- Template Javascript -->
<script src="/common/www/bootstrap/js/main.js"></script>
<script>
    $(document).ready(function () {
        const idFail = "${fail}";
        if (idFail && idFail.trim() !== "") {
            alert(idFail);
        }

        $('#loginForm').on('submit', function (e) {
            let email = $('#email').val();
            let password = $('#password').val();

            if (!email || !password) {
                alert("이메일과 비밀번호를 입력해주세요.");
                e.preventDefault();
            }
        });
    });
</script>