<%--@elvariable id="course" type="by.netcracker.bsuir.pz3.courses.entity.Course"--%>
<%--@elvariable id="user" type="by.netcracker.bsuir.pz3.courses.entity.User"--%>
<%--@elvariable id="teachers" type="java.util.List<by.netcracker.bsuir.pz3.courses.entity.Teacher>"--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Updating course</title>
    <link href="<c:url value="/resources/bootstrapTheme/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrapTheme/css/landing-page.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/courses-theme/css/courses-main-theme.css"/>" rel="stylesheet">
</head>
<body>
<a name="about"></a>
<div class="banner intro-header full-page-height">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div align="center">
                    <h1>Updating the course</h1>
                    <h3>Change information you need:</h3>
                    <hr class="intro-divider">

                    <label class="warning-text">${somethingWrongMessage}</label>

                    <form id="updateInfoForm" class="list-inline form-group"
                          action="<c:url value="/course/updateCourse"/>"
                          method="post">

                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <input class="form-control lead" type="text"
                                   name="courseName" value="${course.courseName}"
                                   placeholder="Course Name">
                        </div>
                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <input class="form-control lead" type="text"
                                   name="subject" value="${course.subject}"
                                   placeholder="Subject">
                        </div>
                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <input class="form-control lead" type="text"
                                   name="lessonsCount" value="${course.lessonsCount}"
                                   placeholder="Lessons count">
                        </div>
                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <input class="form-control lead" type="text"
                                   name="lessonDuration" value="${course.lessonDuration}"
                                   placeholder="Lesson duration (min)">
                        </div>

                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <label>
                                Teacher Last Name <br>
                                <select class="form-control lead" name="teacherId" form="updateInfoForm">
                                    <c:forEach var="teacher" items="${teachers}">
                                        <option
                                                class="lead"
                                                value=${teacher.id}
                                                        <c:if test="${teacher == course.teacher}">selected</c:if> >
                                                ${teacher.user.lastName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </label>
                        </div>

                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <button class="btn btn-default btn-lg" type="submit">Update course</button>
                            <br>
                            <br>
                            <span class="network-name">
                                    <a href="<c:url value="/course/coursesToChange"/>"
                                       class="color-link">Back</a> to courses list
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
