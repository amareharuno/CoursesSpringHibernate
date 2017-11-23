<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Adding course</title>

    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/font-awesome-4.7.0/css/font-awesome.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrapTheme/css/landing-page.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/courses-theme/css/courses-main-theme.css"/>" rel="stylesheet">

    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
</head>

<body>
    <div class="banner intro-header full-page-height">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div>
                        <h1>Adding a new course</h1>
                        <h3>Enter some information about the course:</h3>
                        <hr class="intro-divider">

                        <label class="warning-text">${somethingWrongMessage}</label>

                        <form id="addingCourseForm" class="list-inline form-group"
                              action="${pageContext.request.contextPath}/course/addCourse"
                              method="post">

                            <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                                <input class="form-control lead" type="text" name="courseName" placeholder="Course Name">
                            </div>
                            <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                                <input class="form-control lead" type="text" name="subject" placeholder="Subject">
                            </div>
                            <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                                <input class="form-control lead" type="text" name="lessonsCount" placeholder="Lessons count">
                            </div>
                            <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                                <input class="form-control lead" type="text" name="lessonDuration" placeholder="Lesson duration (min)">
                            </div>

                            <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                                <label>
                                    Teacher Last Name <br>
                                    <select class="form-control lead" name="teacherId" form="addingCourseForm">
                                        <c:forEach var="teacher" items="${teachers}">
                                            <option selected class="lead" value=${teacher.id}>${teacher.user.lastName}</option>
                                        </c:forEach>
                                    </select>
                                </label>
                            </div>

                            <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                                <button class="btn btn-default btn-lg" type="submit">Create course</button>
                                <br>
                                <br>
                                <span class="network-name">
                                    <a href="<c:url value="/course/coursesToChange"/>" class="color-link">Back</a> to courses list
                                </span>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
