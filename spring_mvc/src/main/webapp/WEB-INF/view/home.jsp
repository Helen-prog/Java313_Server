<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Главная страница</h1>

<%--<%--%>
<%--    String name = (String) request.getAttribute("name");--%>
<%--    Integer age = (Integer) request.getAttribute("age");--%>
<%--    List<String> nameList = (List<String>) request.getAttribute("nameList");--%>
<%--%>--%>

<%--<h3>Name: <%= name %></h3>--%>
<%--<h3>Age: <%= age %></h3>--%>
<%--<h3>Name List: <%= nameList %></h3>--%>

<%--<ul>--%>
<%--    <% for(String s : nameList) {%>--%>
<%--    <li><%= s %></li>--%>
<%--    <% } %>--%>
<%--</ul>--%>

<%--<h3>Name: ${name}</h3>--%>
<%--<h3>Age: ${age}</h3>--%>
<%--<h3>Name List: ${nameList}</h3>--%>
<%--<ul>--%>
<%--    <c:forEach items="${nameList}" var="n">--%>
<%--&lt;%&ndash;        <li>${n}</li>&ndash;%&gt;--%>
<%--        <li><c:out value="${n}"></c:out></li>--%>
<%--    </c:forEach>--%>
<%--</ul>--%>
<%--<a href="login">Login</a>--%>
<a href="register">Регистрация</a>
</body>
</html>
