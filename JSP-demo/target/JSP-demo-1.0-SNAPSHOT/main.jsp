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
        <h1>使用 POST 方法读取数据</h1>
        <table>
            <tr>
                <td><b>站点名：</b></td>
                <td>
                    <label>
                        <b><%= request.getParameter("name")%>
                        </b>
                    </label>
                </td>
            </tr>
            <tr>
                <td><b>密码：</b></td>
                <td>
                    <label>
                        <b><%= request.getParameter("url")%>
                        </b>
                    </label>
                </td>
            </tr>
        </table>
        <h1>从复选框中读取数据</h1>
        <ul>
            <li><p><b>Google 是否选中:</b>
                <%= request.getParameter("google")%>
            </p></li>
            <li><p><b>菜鸟教程是否选中:</b>
                <%= request.getParameter("runoob")%>
            </p></li>
            <li><p><b>淘宝是否选中:</b>
                <%= request.getParameter("taobao")%>
            </p></li>
        </ul>
    </body>
</html>