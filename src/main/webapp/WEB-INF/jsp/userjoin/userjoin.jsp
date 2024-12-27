<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script src="../../../js/jquery-3.7.1.js"></script>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
    <h2>Sign Up</h2>
    <form action="/index.jsp" method="post">
        <!-- 이메일 입력 -->
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required autocomplete='off'>
        <br><br>
        <!-- 이름 입력 -->
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required autocomplete='off'>
        <br><br>

        <!-- 비밀번호 입력 -->
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required autocomplete='off' >
        <br><br>
        <!-- 비밀번호 확인 -->
        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required autocomplete='off' >
        <br><br>

        <!-- 제출 버튼 -->
        <button type="submit">Sign Up</button>
    </form>
</body>
</html>
<script>
    $(document).ready(function () {
        $('form').on('submit', function (e) {
           // 비밀번호와 비밀번호 확인 필드 값 가져오기
           var password = $('#password').val();
           var confirmPassword = $('#confirmPassword').val();



           // 비밀번호 일치 여부 확인
            if (password !== confirmPassword) {
                e.preventDefault(); // 폼 제출 중지
                alert('비밀번호와 비밀번호 확인 값이 일치하지 않습니다.'); // 경고 메시지
            }
        });
    });
</script>

