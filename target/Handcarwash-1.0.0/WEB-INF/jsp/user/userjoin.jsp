<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="/js/jquery-3.7.1.js"></script>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
    <h2>Sign Up</h2>
    <form id="signupFormBt" action="/api/v1/auth/join.do" method="post">
        <!-- 이메일 입력 -->
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required autocomplete='off'>
        <div id="emailCheck"></div>
        <br>
        <!-- 이름 입력 -->
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required autocomplete='off'>
        <br><br>

        <!-- 비밀번호 입력 -->
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required autocomplete='off' >
        <div id="passwordCheck">8 ~ 16자의 영문 대/소문자, 숫자, 특수문자를 사용해 주세요.</div>
        <!-- 비밀번호 확인 -->
        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required autocomplete='off' >
        <br><br>

        <!-- 제출 버튼 -->
        <button type="button" id="signupBt">Sign Up</button>
    </form>
</body>
</html>
<script>
    let form = $('#signupFormBt');
    $(document).ready(function () {

        $('#signupBt').on('click', function (e) {

            let email = $('#email').val();
            let password = $('#password').val();
            var confirmPassword = $('#confirmPassword').val();

            var emailRegex = /^[a-zA-Z0-9._%+-]+@(gmail\.com|yahoo\.com|outlook\.com|naver\.com|hanmail\.net|daum\.net|hotmail\.com|icloud\.com|aol\.com|protonmail\.com)$/;
            var regExp = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/;

            let emailCheck = emailRegex.test(email);
            if (!emailCheck) {
                $('#emailCheck').text("이메일을 확인 해주세요.");
                return;
            }
            let pwCheck = regExp.test(password);
            if (!pwCheck){
                alert("8 ~ 16자의 영문 대/소문자, 숫자, 특수문자를 사용해 주세요.");
                return;
            }

           // 비밀번호 일치 여부 확인
            if (password !== confirmPassword) {
                alert('비밀번호와 비밀번호 확인 값이 일치하지 않습니다.'); // 경고 메시지
                return;
            }

            $.ajax({
                url: '/api/v1/auth/emailchecks.do',
                method: 'GET',
                data: { email: email }, // 쿼리 파라미터로 전달
                dataType: 'json',
                success: function (response) {
                    if (response == true){
                        $('#emailCheck').text("이미 가입한 이메일 입니다.");
                    } else {
                        form.submit();
                    }
                },
                error: function (xhr, status, error) {
                    console.error("Error: " + error);
                }
            });
        });
    });
</script>

