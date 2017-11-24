<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Courses</title>

    <link href="<c:url value="/resources/courses-theme/css/courses-main-theme.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/bootstrapTheme/css/landing-page.css"/>" rel="stylesheet">

    <link href="<c:url value="/resources/font-awesome-4.7.0/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="jspf/teacher-nav-bar.jspf"%>

<form id="refreshCoursesForm" action="<c:url value="/course/coursesToChange"/>"></form>
<form id="addCourseForm" action="<c:url value="/course/addingCoursePage"/>"></form>
<form id="deleteForm" action="<c:url value="/course/coursesToChange/delete"/>" method="post"></form>
<form id="updateForm" action="<c:url value="/course/updatingCoursePage"/>" method="post"></form>

<div class="banner full-page-height">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div>
                    <div><h2>Courses</h2></div>
                    <div class="warning-text"> ${somethingWrongMessage} </div>

                    <table id="coursesTable" class="table table-hover bg-color-table">
                        <thead>
                        <tr>
                            <th>Course Id</th>
                            <th>Course Name</th>
                            <th>Subject</th>
                            <th>Lessons count</th>
                            <th>Lesson duration (min)</th>
                            <th>Course duration (min)</th>
                            <th>Teacher Name</th>
                            <th>Teacher Last Name</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
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
                                            class="btn btn-primary fa fa-wrench" aria-hidden="true"></button>
                                </td>
                                <td>
                                    <button type="submit" form="deleteForm"
                                            name="itemToDelete" value="${course.id}"
                                            class="btn btn-danger fa fa-trash" aria-hidden="true"></button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                    <div class="buttons">
                        <button type="submit" form="addCourseForm" class="btn btn-default btn-lg">Add course to list</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
