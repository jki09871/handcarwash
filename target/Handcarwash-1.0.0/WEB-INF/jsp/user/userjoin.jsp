<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/cmmn/header.jsp" %>
<script src="/js/jquery-3.7.1.js"></script>
<div class="about d-flex justify-content-center align-items-center custom-form-wrapper">
    <div class="custom-form-container">
        <h2 class="form-title">Sign Up</h2>
        <form id="signupFormBt" action="/api/v1/auth/join.do" method="post" class="custom-form">
            <!-- 이메일 입력 -->
            <div class="form-group">
                <label for="email" class="form-label">Email</label>
                <input type="email" id="email" name="email" required autocomplete="off" class="form-control custom-input">
                <div id="emailCheck" class="form-text"></div>
            </div>

            <!-- 이름 입력 -->
            <div class="form-group">
                <label for="name" class="form-label">Name</label>
                <input type="text" id="name" name="name" required autocomplete="off" class="form-control custom-input">
            </div>

            <!-- 비밀번호 입력 -->
            <div class="form-group">
                <label for="password" class="form-label">Password</label>
                <input type="password" id="password" name="password" required autocomplete="off" class="form-control custom-input">
                <div id="passwordCheck" class="form-text">8 ~ 16자의 영문 대/소문자, 숫자, 특수문자를 사용해 주세요.</div>
            </div>

            <!-- 비밀번호 확인 -->
            <div class="form-group">
                <label for="confirmPassword" class="form-label">Confirm Password</label>
                <input type="password" id="confirmPassword" name="confirmPassword" required autocomplete="off" class="form-control custom-input">
            </div>

            <!-- 버튼 그룹 -->
            <div class="form-actions d-flex justify-content-center">
                <button type="button" id="signupBt" class="btn custom-btn">Sign Up</button>
            </div>
        </form>
    </div>
</div>

<%@ include file="/WEB-INF/jsp/cmmn/footer.jsp" %>

<script>
    let form = $('#signupFormBt');
    $(document).ready(function () {

        $('#signupBt').on('click', function (e) {

            // 텍스트 값
            let email = $('#email').val();
            let name = $('#name').val();
            let password = $('#password').val();
            let confirmPassword = $('#confirmPassword').val();

            // 이메일 검사 정규표현식
            var emailRegex = /^[a-zA-Z0-9._%+-]+@(gmail\.com|yahoo\.com|outlook\.com|naver\.com|hanmail\.net|daum\.net|hotmail\.com|icloud\.com|aol\.com|protonmail\.com)$/;
            // 이름 검사 정규 표현식
            var nameRegex = /^[가-힣a-zA-Z]{2,100}$/;
            // 비밀번호 검사 정규 표현식
            var pwRegExp = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/;

            // 이메일 검사
            let emailCheck = emailRegex.test(email);
            if (!emailCheck) {
                $('#emailCheck').text("이메일을 확인 해주세요.");
                return;
            }

            // 이름 검사
            let nameCheck = nameRegex.test(name);
            if (!nameCheck) {
                alert("이름은 2~20자의 한글 또는 영문만 입력 가능합니다.");
                return;
            }

            // 비밀번호 검사
            let pwCheck = pwRegExp.test(password);
            if (!pwCheck){
                alert("8 ~ 16자의 영문 대/소문자, 숫자, 특수문자를 사용해 주세요.");
                return;
            }

           // 비밀번호 일치 여부 확인
            if (password !== confirmPassword) {
                alert('비밀번호를 확인 해주세요.'); // 경고 메시지
                return;
            }

            // 이메일 중복 확인
            $.ajax({
                url: '/api/v1/auth/emailValidCheck.do',
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

