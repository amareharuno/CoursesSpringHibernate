<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Courses</title>

        <!-- Bootstrap Core CSS -->
        <link href="${pageContext.request.contextPath}/resources/bootstrapTheme/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="${pageContext.request.contextPath}/resources/bootstrapTheme/css/landing-page.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/profileStyle.css">

        <!-- Custom Fonts -->
        <link href="${pageContext.request.contextPath}/resources/bootstrapTheme/font-awesome/css/font-awesome.min.css"
              rel="stylesheet"
              type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
              rel="stylesheet"
              type="text/css">
    </head>
    <body>
    <div class="header_back">
        <div class="header">
            <div class="logo_pic">
                <a href="<c:url value="/index"/>" style="color: #5bc0de">Log out</a>
            </div>
        </div>
    </div>
    <!-- Header -->
    <a name="about">
        <div class="banner">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="intro-message" align="center">

                            <form action="${pageContext.request.contextPath}/course/courses" method="get">
                                <input type="submit" value="Refresh course list" required style="color: #122b40">
                            </form>

                            <table id="coursesTable" class="table-bordered" style="background-color: #adadad">
                                <caption style="color: #122b40">
                                    <h2>Courses</h2>
                                </caption>
                                <tr>
                                    <%--<th></th>--%>
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
                                    <%--
                                    <td>
                                        <input type="radio" name="courseId" id="${course.id}" value="${course.id}">
                                    </td>
                                    --%>
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
                                <a href="<c:url value="/student"/>" style="color: #5bc0de">
                                    <u>Go back</u>
                                </a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.container -->
        </div>
    </a>
    </body>
</html>