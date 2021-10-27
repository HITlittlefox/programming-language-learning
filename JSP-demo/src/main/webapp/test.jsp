<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>菜鸟教程(runoob.com)</title>
    </head>
    <body>

        <form action="main.jsp" method="POST" target="_blank">
            <table>
                <tr>
                    <td>站点名：</td>
                    <td><label>
                        <input type="text" name="name">
                    </label></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><label>
                        <input type="text" name="url">
                    </label></td>
                </tr>
                <tr>
                    <input type="checkbox" name="google" checked="checked"/>Google
                    <input type="checkbox" name="runoob"/> 菜鸟教程
                    <input type="checkbox" name="taobao" checked="checked"/>淘宝
                </tr>
            </table>
            <input type="submit" value="提交">
        </form>
    </body>
</html>