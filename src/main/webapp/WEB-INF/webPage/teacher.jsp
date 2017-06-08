<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Teacher</title>
</head>
<body>
    <div class="container" align="center">
        <form action="${pageContext.request.contextPath}/teacher/teachers" method="get">
            <input type="submit" value="Show teachers">
        </form>
        <form action="${pageContext.request.contextPath}/course/courses" method="get">
            <input type="submit" value="Show courses">
        </form>
        <table id="teachersTable" class="table-bordered">
            <caption>Teachers</caption>
            <tr>
                <th></th>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Middle name</th>
            </tr>
            <c:forEach var="teacher" items="${teachers}">
                <tr>
                    <td>
                        <input type="radio" name="teacherId" id="${teacher.id}" value="${teacher.id}">
                    </td>
                    <td>${teacher.id}</td>
                    <td>${teacher.user.firstName}</td>
                    <td>${teacher.user.lastName}</td>
                    <td>${teacher.user.middleName}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
