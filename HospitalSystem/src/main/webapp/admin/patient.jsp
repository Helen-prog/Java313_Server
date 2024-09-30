<%@ page import="com.dao.AppointmentDAO, com.db.DBConnect, com.dao.DoctorDao, java.util.List, com.entity.Appointment, com.entity.Doctor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../component/allcss.jsp"/>
</head>
<body>
<%--<c:if test="${empty doctorObj}">--%>
<%--    <c:redirect url="../doctor_login.jsp"></c:redirect>--%>
<%--</c:if>--%>
<jsp:include page="navbar.jsp"/>
<div class="patient">
    <div class="wrap">
        <h2>Данные пациента</h2>
<%--        <c:if test="${not empty errorMsg}">--%>
<%--        <p class="center text-danger fs-3">${errorMsg}</p>--%>
<%--            <c:remove var="errorMsg" scope="session" />--%>
<%--        </c:if>--%>
<%--        <c:if test="${not empty succMsg}">--%>
<%--        <p class="center text-success fs-3">${succMsg}</p>--%>
<%--            <c:remove var="succMsg" scope="session" />--%>
<%--        </c:if>--%>
        <table class="table">
            <tr>
                <th scope="col">ФИО</th>
                <th scope="col">Пол</th>
                <th scope="col">Возраст</th>
                <th scope="col">Дата назначения</th>
                <th scope="col">Email</th>
                <th scope="col">Телефон</th>
                <th scope="col">Диагноз</th>
                <th scope="col">Имя врача</th>
                <th scope="col">Адрес</th>
                <th scope="col">Статус</th>
            </tr>
            <%
                AppointmentDAO dao = new AppointmentDAO(DBConnect.getConn());
                DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
                List<Appointment> list = dao.getAllAppointment();
                for (Appointment appointment : list) {
                    Doctor d = dao2.getDoctorsById(appointment.getDoctorId());
                    %>
            <tr>
                <td><%= appointment.getFullName() %></td>
                <td><%= appointment.getGender() %></td>
                <td><%= appointment.getAge() %></td>
                <td><%= appointment.getAppointDate() %></td>
                <td><%= appointment.getEmail() %></td>
                <td><%= appointment.getPhone() %></td>
                <td><%= appointment.getDiseases() %></td>
                <td><%= d.getFullName() %></td>
                <td><%= appointment.getAddress() %></td>
                <td><%= appointment.getStatus() %></td>
            </tr>
            <%
                }
            %>

        </table>
    </div>
</div>
</body>
</html>