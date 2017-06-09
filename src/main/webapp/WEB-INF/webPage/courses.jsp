<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Courses</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/bootstrapTheme/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/bootstrapTheme/css/landing-page.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/bootstrapTheme/font-awesome/css/font-awesome.min.css"
          rel="stylesheet"
          type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
          rel="stylesheet"
          type="text/css">
</head>
<body>
<!-- Header -->
<a name="about"></a>
<div class="banner">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="intro-message" align="center">

                    <form action="${pageContext.request.contextPath}/course/courses" method="get">
                        <input type="submit" value="Update course list" required style="color: #122b40">
                    </form>
                    <%--
                    <form action="${pageContext.request.contextPath}/course/add" method="get">
                        <input type="submit" value="Add course">
                    </form>
                    --%>
                    <table id="coursesTable" class="table-bordered" style="background-color: #adadad">
                        <caption style="color: #122b40">
                            <h4>Courses</h4>
                        </caption>
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
            </div>
        </div>
    </div>
    <!-- /.container -->
</div>
</body>
</html>
