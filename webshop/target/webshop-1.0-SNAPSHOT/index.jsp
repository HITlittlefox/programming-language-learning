<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="java.sql.*" %>


<%
    //数据库链接
    String userName = "root";
    String userPassword = "123456";
    String dbName = "web2021";

    //拼接url、解决时区问题、注意等号问题、注意?与&的区分
    String url = "jdbc:mysql://localhost:3306/" + dbName + "?serverTimezone=GMT" + "&user=" + userName + "&password=" + userPassword;
    //装载驱动
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    //实例化链接
    Connection conn = DriverManager.getConnection(url);
    Statement stmt = conn.createStatement();
    //显示数据库链接状态
    if (conn != null) {
%>
<h2><%="数据库连接成功！"%>
</h2>
<%
    }
%>

<%--todo (已完成)登陆后在index.jsp显示姓名--%>

<!DOCTYPE html>
<html>
    <head>
        <title>webshop</title>
    </head>
    <body>
        <%
            //这里拿到的其实是一个userid，数据库第一列名
            String userid = (String) session.getAttribute("userid");

            //    System.out.println("This is what you get from check.jsp");
            //    System.out.println(userid);

            String sql = "select name from users where userid=" + userid;

            //    System.out.println(sql);

            stmt.execute(sql);
            ResultSet rs = stmt.executeQuery(sql);

            //    System.out.println("BELOW IS YOUR id！");
            //    System.out.println(userid);

            if (userid != null) {
        %>
        <h2>您的id：<%=userid%>
        </h2>
        <%
            } else {
                System.out.println("userid = nothing");
            }
        %>
        <%
            while (rs.next()) {
        %>
        <h2>您的用户名：
            <%=rs.getString("name")%>
        </h2>
        <%
            }
        %>


        <h1><%= "Hello World!" %>
        </h1>
        <h1>电子商城首页</h1>
        <br/>
        <h2><a href="hello-servlet">Hello Servlet</a></h2>
        <br/>
        <h2><a href="login.jsp">登录</a></h2>
        <br/>
        <h2><a href="register.jsp">注册</a></h2>
        <br/>
    </body>
</html>