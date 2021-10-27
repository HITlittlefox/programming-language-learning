<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>登录</title>
    </head>
    <body>
        <h1>欢迎访问Spring Boot课堂</h1>
        <form method="get" action="logincheck.jsp">
            <table>
                <tr>
                    <td>用户名：</td>
                    <td><label>
                        <input type="text" name="user">
                    </label></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><label>
                        <input type="text" name="psd">
                    </label></td>
                </tr>

            </table>
            <input type="submit" value="提交">
        </form>

    </body>
</html>