<%@ page import="jakarta.servlet.http.Cookie" %><%--
  Created by IntelliJ IDEA.
  User: Maxwell
  Date: 2024/12/20
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
String val="";

Cookie[] cookies = request.getCookies();
if(cookies!=null){
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("uname")){
            val=cookie.getValue();
            pageContext.setAttribute("value",val);
        }
    }
}
%>
获取cookie值，key=uname,value=${value};
<h1>show.jsp---登录成功,欢迎:${sessionScope.username}</h1>

<%
    out.println("登录人为：" +session.getAttribute("username"));
%>

<h1><a href="getcookie">getcookies</a></h1>

</body>
</html>
