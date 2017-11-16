<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Courses</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/font-awesome-4.7.0/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
    <script src="<c:url value="/resources/jquery/jquery-3.2.1.min.js"/>"></script>
</head>
<body>
<!-- Header -->
<form id="refreshCoursesForm" action="<c:url value="/course/coursesToChange"/>"></form>
<form id="addCourseForm" action="<c:url value="/course/addingCoursePage"/>"></form>
<form id="deleteForm" action="<c:url value="/course/coursesToChange/delete"/>" method="post"></form>
<form id="updateForm" action="<c:url value="/course/updatingCoursePage"/>" method="post"></form>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="intro-message" align="center">
                <div style="color: #122b40">
                    <h2>Courses</h2>
                </div>

                <div class="buttons">
                    <input type="submit" form="refreshCoursesForm" value="Refresh course list">
                    <input type="submit" form="addCourseForm" value="Add course to list">
                </div>

                <table id="coursesTable" class="table-bordered">
                    <label style="color: yellow; size: 26pt">${somethingWrongMessage}</label>
                    <tr>
                        <th>Course Id</th>
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
                            <td>${course.id}</td>
                            <td>${course.courseName}</td>
                            <td>${course.subject}</td>
                            <td>${course.lessonsCount}</td>
                            <td>${course.lessonDuration}</td>
                            <td>${course.courseDuration}</td>
                            <td>${course.teacher.user.firstName}</td>
                            <td>${course.teacher.user.lastName}</td>
                            <td>
                                <button type="submit" form="updateForm"
                                        name="itemToUpdate" value="${course.id}"
                                        class="fa fa-wrench" aria-hidden="true"></button>
                            </td>
                            <td>
                                <button type="submit" form="deleteForm"
                                        name="itemToDelete" value="${course.id}"
                                        class="fa fa-trash" aria-hidden="true"></button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <p class="network-name">
                    <br>
                    <a href="<c:url value="/teacher"/>" style="color: #5bc0de">
                        <u>Go back to teacher's page</u>
                    </a>
                </p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
