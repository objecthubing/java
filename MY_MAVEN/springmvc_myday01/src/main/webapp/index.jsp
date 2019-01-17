<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>

<h1>入门</h1>

<a href="show">点我</a>

<form action="/user/show1" method="get">
    用户名: <input type="text" name="username"> <br>
    密&nbsp;&nbsp;码: <input type="password" name="password"><br>
    年&nbsp;&nbsp;龄: <input type="text" name="age"><br>

    卡号:<input type="text" name="card.cno"><br>
    银行: <input type="text" name="card.bank"><br>
    <input type="submit" value="注册">
</form>
</body>


</html>
