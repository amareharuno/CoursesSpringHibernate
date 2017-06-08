<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student</title>
</head>
<body>

<div class="container">
    <div class="row" align="center">
        <form action="${pageContext.request.contextPath}/student/students" method="get">
            <input type="submit" value="Show students">
        </form>
        <table id="studentTable" class="table-bordered">
            <caption>Students</caption>
            <tr>
                <th></th>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Middle name</th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>
                        <input type="radio" name="teacherId" id="${student.id}" value="${student.id}">
                    </td>
                    <td>${student.id}</td>
                    <td>${student.user.firstName}</td>
                    <td>${student.user.lastName}</td>
                    <td>${student.user.middleName}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>

