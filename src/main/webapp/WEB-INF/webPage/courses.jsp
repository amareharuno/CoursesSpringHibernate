<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Courses</title>

    <link href="<c:url value="/resources/bootstrapTheme/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrapTheme/css/landing-page.css"/>" rel="stylesheet">

    <link href="<c:url value="/resources/courses-theme/css/courses-main-theme.css"/>" rel="stylesheet">
</head>
<body>
<%@include file="jspf/student-nav-bar.jspf"%>
<div class="banner full-page-height">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div>
                    <div class="page-name"><h2>Courses</h2></div>
                    <table id="coursesTable" class="table table-hover bg-color-table">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Course Name</th>
                                <th>Subject</th>
                                <th>Lessons count</th>
                                <th>Lesson duration (min)</th>
                                <th>Course duration (min)</th>
                                <th>Teacher Name</th>
                                <th>Teacher Last Name</th>
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
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>