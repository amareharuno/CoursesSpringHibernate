<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Adding course</title>

    <!-- Bootstrap -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>

    <link href="<c:url value="/resources/bootstrapTheme/css/landing-page.css"/>" rel="stylesheet">

    <script src="<c:url value="/resources/jquery/jquery-3.2.1.min.js"/>"></script>
    <link href="<c:url value="/resources/font-awesome-4.7.0/css/font-awesome.min.css"/>" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/myCss.css"/>">

    <%--<link href="/resources/bootstrap/css/landing-page.css" rel="stylesheet">--%>
    <%--<link rel="stylesheet" type="text/css" href="/resources/profileStyle.css">--%>
    <!-- Custom Fonts -->
    <%--<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet">--%>
</head>
<body>
<div class="banner intro-header">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="intro-message" align="center">
                    <h1>Adding a new course</h1>
                    <h3>Enter some information about the course:</h3>
                    <hr class="intro-divider">
                    <label style="color: yellow; size: 26pt">${somethingWrongMessage}</label>
                    <form id="signUpForm" class="list-inline form-group"
                          action="${pageContext.request.contextPath}/course/addCourse" method="post">
                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <input class="form-control lead" type="text" name="courseName" placeholder="Course Name"
                                   required="" style="color: #122b40">
                        </div>
                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <input class="form-control lead" type="text"
                                   name="subject" placeholder="Subject"
                                   required style="color: #122b40">
                        </div>
                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <input class="form-control lead" type="text"
                                   name="lessonsCount" placeholder="Lessons count"
                                   required style="color: #122b40">
                        </div>
                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <input class="form-control lead" type="text"
                                   name="lessonDuration" placeholder="Lesson duration (min)"
                                   required style="color: #122b40">
                        </div>
                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <label>
                                Teacher Last Name <br>
                                <select class="form-control lead" name="teacherId" form="signUpForm" required
                                        style="color: #122b40">
                                    <c:forEach var="teacher" items="${teachers}">
                                        <option selected class="lead" value=${teacher.id}>"${teacher.user.lastName}"
                                        </option>
                                    </c:forEach>
                                </select>
                            </label>
                        </div>
                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <input class="btn btn-default btn-lg" type="submit" value="Create course">
                            <p class="network-name">
                                <br>
                                <a href="<c:url value="/course/coursesToChange"/>" style="color: #5bc0de">
                                    <u>Back</u>
                                </a>
                                <span> to courses list</span>
                            </p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
