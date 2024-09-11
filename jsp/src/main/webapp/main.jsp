<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <section>
        <form action="user.jsp" method="post">
            <p>Имя: <input name="username"></p>
            <p>Пол: <br>
                <label for="female">
                    <input type="radio" name="gender" value="женский" id="female"> Ж <br>
                </label>
                <label for="male">
                    <input type="radio" name="gender" value="М" id="male"> М
                </label>
            </p>
            <p>Страна:
                <select name="country">
                    <option value="ru">Россия</option>
                    <option>Беларусь</option>
                    <option>Турция</option>
                </select>
            </p>
            <p>Курс обучения: <br>
                <label for="java">
                    <input type="checkbox" name="courses" id="java" value="Java"> Java <br>
                </label>
                <label for="html">
                    <input type="checkbox" name="courses" id="html" value="HTML"> HTML <br>
                </label>
                <label for="js">
                    <input type="checkbox" name="courses" id="js" value="JavaScript"> JS <br>
                </label>
            </p>
            <p><input type="submit" value="Подтвердить"></p>
        </form>
    </section>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
