<%--@elvariable id="course" type="by.netcracker.bsuir.pz3.courses.entity.Course"--%>
<%--@elvariable id="user" type="by.netcracker.bsuir.pz3.courses.entity.User"--%>
<%--@elvariable id="teachers" type="java.util.List<by.netcracker.bsuir.pz3.courses.entity.Teacher>"--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Updating course</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/bootstrapTheme/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/myCss.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrapTheme/css/landing-page.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/profileStyle.css"/>" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/bootstrapTheme/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
          rel="stylesheet">
</head>
<body>
<div class="header_back">
    <div class="header">
        <div class="logo_pic">
            <a href="<c:url value="/index"/>" style="color: #5bc0de">Log out</a>
        </div>
    </div>
</div>
<a name="about"></a>
<div class="banner">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="intro-message" align="center">
                    <h1>Updating the course</h1>
                    <h3>Change information you need:</h3>
                    <hr class="intro-divider">
                    <label style="color: yellow; size: 26pt">${somethingWrongMessage}</label>
                    <form id="updateInfoForm" class="list-inline" action="<c:url value="/course/updateCourse"/>" method="post">
                        <p>
                            <input class="lead" type="text"
                                   name="courseName" placeholder="Course Name"
                                   value="${course.courseName}"
                                   required style="color: #122b40">
                            <br>
                            <input class="lead" type="text"
                                   name="subject" placeholder="Subject"
                                   value="${course.subject}"
                                   required style="color: #122b40"/>
                            <br>
                            <input class="lead" type="text"
                                   name="lessonsCount" placeholder="Lessons count"
                                   value="${course.lessonsCount}"
                                   required style="color: #122b40"/>
                            <br>
                            <input class="lead" type="text"
                                   name="lessonDuration" placeholder="Lesson duration (min)"
                                   value="${course.lessonDuration}"
                                   required style="color: #122b40"/>
                            <br>
                            <label>
                                Teacher Last Name <br>
                                <select class="lead" name="teacherId" form="updateInfoForm" required
                                        style="color: #122b40">
                                    <c:forEach var="teacher" items="${teachers}">
                                        <option class="lead" value=${teacher.id}
                                                <c:if test="${teacher.user.id == course.teacher.id}">selected</c:if> >
                                                ${teacher.user.lastName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </label>
                        </p>
                        <p>
                            <button class="btn btn-default btn-lg" type="submit">Update course</button>
                        </p>
                    </form>

                    <p class="network-name">
                        <br>
                        <a href="<c:url value="/course/coursesToChange"/>" style="color: #5bc0de">
                            <u>Back</u>
                        </a>
                        <span> to courses list</span>
                    </p>
                </div>
            </div>
        </div>
    </div>
    <!-- /.container -->
</div>
<!-- /.intro-header -->
</body>
</html>
