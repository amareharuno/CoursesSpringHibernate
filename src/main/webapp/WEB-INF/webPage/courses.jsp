<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Courses</title>
</head>
<body>
<div class="container" align="center">
    <form action="${pageContext.request.contextPath}/course/courses" method="get">
        <input type="submit" value="Update course list">
    </form>
    <%--
    <form action="${pageContext.request.contextPath}/course/add" method="get">
        <input type="submit" value="Add course">
    </form>
    --%>
    <table id="coursesTable" class="table-bordered">
        <caption>Courses</caption>
        <tr>
            <th></th>
            <th>Id</th>
            <th>Course Name</th>
            <th>Subject</th>
            <th>Lessons count</th>
            <th>Lesson duration (min)</th>
            <th>Course duration (min)</th>
            <th>Teacher Name</th>
            <th>Teacher Last Name</th>
        </tr>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>
                    <input type="radio" name="courseId" id="${course.id}" value="${course.id}">
                </td>
                <td>${course.id}</td>
                <th>${course.courseName}</th>
                <th>${course.subject}</th>
                <th>${course.lessonsCount}</th>
                <th>${course.lessonDuration}</th>
                <th>${course.courseDuration}</th>
                <th>${course.teacher.user.firstName}</th>
                <th>${course.teacher.user.lastName}</th>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
