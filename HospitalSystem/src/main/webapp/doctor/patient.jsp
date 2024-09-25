<%@ page import="com.entity.Doctor, com.dao.AppointmentDAO, com.db.DBConnect, java.util.List, com.entity.Appointment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../component/allcss.jsp"/>
</head>
<body>
<c:if test="${empty doctorObj}">
    <c:redirect url="../doctor_login.jsp"></c:redirect>
</c:if>
<jsp:include page="navbar.jsp"/>
<div class="doctor">
    <div class="wrap">
        <h2>Просмотр назначения</h2>
        <c:if test="${not empty errorMsg}">
            <p class="center text-danger fs-3">${errorMsg}</p>
            <c:remove var="errorMsg" scope="session" />
        </c:if>
        <c:if test="${not empty succMsg}">
            <p class="center text-success fs-3">${succMsg}</p>
            <c:remove var="succMsg" scope="session" />
        </c:if>
        <table class="table">
            <tr>
                <th scope="col">ФИО</th>
                <th scope="col">Пол</th>
                <th scope="col">Возраст</th>
                <th scope="col">Дата назначения</th>
                <th scope="col">Email</th>
                <th scope="col">Телефон</th>
                <th scope="col">Диагноз</th>
                <th scope="col">Статус</th>
                <th scope="col">Действие</th>
            </tr>
            <%
                Doctor doc = (Doctor) session.getAttribute("doctorObj");
                AppointmentDAO dao = new AppointmentDAO(DBConnect.getConn());
                List<Appointment> list = dao.getAllAppointmentByDoctorLogin(doc.getId());
                for (Appointment app : list) {
            %>
            <tr>
                <td><%= app.getFullName() %></td>
                <td><%= app.getGender() %></td>
                <td><%= app.getAge() %></td>
                <td><%= app.getAppointDate() %></td>
                <td><%= app.getEmail() %></td>
                <td><%= app.getPhone() %></td>
                <td><%= app.getDiseases() %></td>
                <td><%= app.getStatus() %></td>
                <td>
                    <a href="comment.jsp?id=<%= app.getId() %>" class="btn btn-sm btn-info">Комментарий</a>
                </td>
            </tr>
            <%
                }
            %>

        </table>
    </div>
</div>
</body>
</html>
