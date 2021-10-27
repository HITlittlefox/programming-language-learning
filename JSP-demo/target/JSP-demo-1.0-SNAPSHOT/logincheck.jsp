<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>登录校验</title>
    </head>
    <body>

        <h1>读取数据</h1>
        <ul>
            <li><p><b>用户名:</b>
                <%=request.getParameter("user")%>
            </p></li>
            <li><p><b>密码:</b>
                <%=request.getParameter("psd")%>
            </p</li>
        </ul>

    </body>
</html>