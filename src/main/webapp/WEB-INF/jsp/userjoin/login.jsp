<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="../../../js/jquery-3.7.1.js"></script>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login Page</h2>
<form id="loginForm" method="post" action="/api/v1/auth/login.do">
    <label for="email">Email:</label>
    <input type="text" id="email" name="email" required autocomplete="off">
    <br><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" autocomplete="off">
    <br><br>
    <button type="button" id="memberJoin" name="memberJoin"><a href="/api/v1/auth/join.do">회원가입</a></button>
    <button type="submit">Login</button>
</form>
</body>
</html>
<script>
    $(document).ready(function (){

        let idFail = "${fail}";
        if (idFail != ""){
            alert(idFail);
        }

    });

</script>