<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Adding course</title>

    <!-- Bootstrap -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>

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
    <a name="about"></a>
    <div class="banner">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message" align="center">
                        <h1>Adding a new course</h1>
                        <h3>Enter some information about the course:</h3>
                        <hr class="intro-divider">
                        <label style="color: yellow; size: 26pt">${somethingWrongMessage}</label>
                        <form id="signUpForm" class="list-inline"
                              action="${pageContext.request.contextPath}/course/addCourse" method="post">
                            <p>
                                <input class="lead" type="text"
                                       name="courseName" placeholder="Course Name"
                                       required style="color: #122b40">
                                <br>
                                <input class="lead" type="text"
                                       name="subject" placeholder="Subject"
                                       required style="color: #122b40">
                                <br>
                                <input class="lead" type="text"
                                       name="lessonsCount" placeholder="Lessons count"
                                       required style="color: #122b40">
                                <br>
                                <input class="lead" type="text"
                                       name="lessonDuration" placeholder="Lesson duration (min)"
                                       required style="color: #122b40">
                                <br>
                                <label>
                                    Teacher Last Name <br>
                                    <select class="lead" name="teacherId" form="signUpForm" required style="color: #122b40">
                                        <c:forEach var="teacher" items="${teachers}">
                                            <option selected class="lead" value=${teacher.id}>"${teacher.user.lastName}"
                                            </option>
                                        </c:forEach>
                                    </select>
                                </label>
                            </p>
                            <p>
                                <input class="btn btn-default btn-lg" type="submit"
                                       value="Create course">
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
    </div>
</body>
</html>
