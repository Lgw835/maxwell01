<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<form method="post" action="index.jsp">
    <input type="text" name="username" value="nihao"> <br>
    <button type="submit">提交</button>
</form>


<%! String aa="love";
int bb=10;
%>
<%!
    public int test(){
        return bb+25;
    }
%>
aa=<%=aa%>
bb=<%=test()%>
<br>
username=<%=request.getParameter("username")%>
<%--request.getParameter("username")//只能获取表单提交的数据--%>
<hr>
<%
    // 获取表单参数
    String usernameParam = request.getParameter("username");

    // 设置 request 属性
    if (usernameParam != null) {
        request.setAttribute("username", usernameParam);
    }
%>

<%!
    String ab = "you";
    int ba = 15;
%>
<%!
    public int test1() {
        return ba + 25;
    }
%>

aa=<%=ab%> <br>
bb=<%=test1()%> <br>
username=<%=request.getAttribute("username")%>



</body>
</html>