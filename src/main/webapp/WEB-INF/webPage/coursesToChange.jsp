<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Courses</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
    <script src="<c:url value="/resources/jquery/jquery-3.2.1.min.js"/>"></script>
    <script>

    </script>
</head>
<body>
<!-- Header -->
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="intro-message" align="center">
                <div class="buttons">
                    <form action="<c:url value="/course/coursesToChange"/>" method="get">
                        <input type="submit" value="Refresh course list" required style="color: #122b40">
                    </form>
                    <form action="<c:url value="/course/addingCoursePage"/>" method="get">
                        <input type="submit" value="Add course to list" required style="color: #122b40">
                    </form>

                    <form id="deleteForm" action="<c:url value="/course/coursesToChange/delete"/>" method="post">
                        <input form="deleteForm" type="submit" value="Delete course from list" required
                               style="color: #122b40">
                    </form>

                    <form id="updateForm" action="<c:url value="/course/updatingCoursePage"/>" method="get">
                        <input type="submit" value="Update course" required style="color: #122b40">
                    </form>
                </div>

                <table id="coursesTable" class="table-bordered" style="background-color: #adadad">
                    <caption style="color: #122b40">
                        <h2>Courses</h2>
                    </caption>
                    <label style="color: yellow; size: 26pt">${somethingWrongMessage}</label>
                    <tr>
                        <th></th>
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
                            <td>
                                <label>
                                        <%--<input form="deleteForm" type="radio" name="radioId"
                                               id="${course.id}" value="${course.id}"
                                               onchange="updatedItemId_${course.id}.value = this.value">
                                            <input form="updateForm" type="radio" name="radioId"
                                               id="updatedItemId_${course.id}" value="${course.id}" style="display: none">
                                               --%>
                                    <input form="deleteForm" type="radio" name="radioId"
                                           id="${course.id}" value="${course.id}">
                                        <%-- todo --%>
                                    <input form="updateForm" type="radio" name="radioId"
                                           id="updatedItemId_${course.id}" value="${course.id}">
                                </label>
                            </td>
                            <td>${course.id}</td>
                            <td>${course.courseName}</td>
                            <td>${course.subject}</td>
                            <td>${course.lessonsCount}</td>
                            <td>${course.lessonDuration}</td>
                            <td>${course.courseDuration}</td>
                            <td>${course.teacher.user.firstName}</td>
                            <td>${course.teacher.user.lastName}</td>
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
