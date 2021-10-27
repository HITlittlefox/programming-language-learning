package com.example.jspdemo;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {
    public static final String HELLO_WORLD = "Hello world!";
    private String message;

    public void init() {
        message = HELLO_WORLD;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        out.println("<h3>" + request.getRemoteAddr() + "</h3>");
        out.println("<h3>" + request.getRemoteHost() + "</h3>");
        out.println("<h3>" + request.getRemotePort() + "</h3>");
        out.println("<h3>" + request.getRemoteUser() + "</h3>");
        out.println("<h3>" + request.getRequestURI() + "</h3>");
    }

    public void destroy() {
    }
}