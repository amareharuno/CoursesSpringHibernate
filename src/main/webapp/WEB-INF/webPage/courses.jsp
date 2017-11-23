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

                    <form action="<c:url value="/course/courses"/>" method="get">
                        <button class="btn btn-default btn-lg" type="submit">Refresh course list</button>
                    </form>

                    <p class="network-name">
                        <br>
                        <a href="<c:url value="/student"/>" class="color-link">
                            <u>Go back</u>
                        </a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>