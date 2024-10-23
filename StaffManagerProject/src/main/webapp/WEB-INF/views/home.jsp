<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        div{
            text-align: center;
        }
        table{
            border: 1px solid;
            width: 800px;
            margin: 0 auto;
        }
        th, td{
            border: 1px solid;
        }
        .last{
            display: flex;
            justify-content: space-between;
        }
        h4{
            color: green;
        }
    </style>
</head>
<body>
<div>
    <h1>Менеджер по персоналу</h1>
    <c:if test="${not empty msg}">
        <h4>${msg}</h4>
        <c:remove var="msg" />
    </c:if>
    <h3><a href="/new">Новый сотрудник</a></h3>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Action</th>
        </tr>

        <c:forEach items="${employeeList}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.email}</td>
                <td>${employee.address}</td>
                <td class="last">
                    <a href="edit/${employee.id}">Edit</a>
                    <a href="delete/${employee.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
