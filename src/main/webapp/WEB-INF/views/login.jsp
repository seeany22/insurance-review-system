<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>보험 서면심사 업무 지원 시스템</title>
</head>
<body>

<h1>보험 서면심사 업무 지원 시스템</h1>

<form action="/login" method="post">
    <div>
        <label>아이디</label>
        <input type="text" name="empNo">
    </div>

    <div>
        <label>비밀번호</label>
        <input type="password" name="password">
    </div>

    <button type="submit">로그인</button>
</form>

</body>
</html>