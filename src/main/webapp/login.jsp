<%--
  Created by IntelliJ IDEA.
  User: Maxwell
  Date: 2024/12/18
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>

<%
    // 获取用户输入的用户名和密码
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // 简单的用户名验证（在实际应用中，应该查询数据库验证）
    if (username == null || !username.equals("admin")) {
%>
<script type="text/javascript">
    alert("用户名不存在");
    location.href = "login.html";
</script>
<%
} else if (!password.equals("123456")) {
%>
<script type="text/javascript">
    alert("密码错误");
    location.href = "login.html";
</script>
<%
} else {
%>
<script type="text/javascript">
    alert("登录成功");
    location.href = "success.html";
</script>
<%
    }
%>

</body>
</html>
