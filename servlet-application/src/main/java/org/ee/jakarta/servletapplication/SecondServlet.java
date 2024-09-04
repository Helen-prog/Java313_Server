package org.ee.jakarta.servletapplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String parameter1 = req.getParameter("param1");
        var writer = resp.getWriter();
        writer.println("<h1>" + parameter1 + "</h1>");

        Map<String, String[]> parameterMap = req.getParameterMap();
        parameterMap.entrySet().forEach((e) -> writer.println("<h3>" + e.getKey() + "=" + Arrays.toString(e.getValue()) + "</h3>"));
    }
}
