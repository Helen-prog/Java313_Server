<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="application.Calculate" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    for (int i=2; i<10; i++) {
        out.print("<p>" + i + "<sup>2</sup> = " + new Calculate().square(i) + "</p>");
    }
%>
</body>
</html>
