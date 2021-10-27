<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>JSP - Hello World</title>
    </head>
    <body>
        <h1><%= "Hello World!" %>
        </h1>
        <br/>
        <a href="hello-servlet">Hello Servlet</a>
        <br/>
        <a href="hello-cloud">Hello Cloud</a>
        <br/>
        <a href="login.jsp">login</a>
        <br/>
        <a href="logincheck.jsp">logincheck</a>
        <br/>
        <a href="test.jsp">test</a>
        <br/>
        <a href="main.jsp">main</a>
        <br/>
        <a href="autoRefresh.jsp">autoRefresh</a>
        <br/>
        <a href="sessionTest.jsp">sessionTest</a>

        <h2>HTTP 头部请求实例</h2>
        <table width="100%" border="1" align="center">
            <tr bgcolor="#949494">
                <th>Header Name</th>
                <th>Header Value(s)</th>
            </tr>
            <%
                Enumeration<String> headerNames = request.getHeaderNames();
                while (headerNames.hasMoreElements()) {
                    String paramName = (String) headerNames.nextElement();
                    out.print("<tr><td>" + paramName + "</td>\n");
                    String paramValue = request.getHeader(paramName);
                    out.println("<td> " + paramValue + "</td></tr>\n");
                }
            %>
        </table>
    </body>

</html>