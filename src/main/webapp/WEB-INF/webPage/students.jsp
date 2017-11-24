<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Students list</title>

    <link href="<c:url value="/resources/bootstrapTheme/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrapTheme/css/landing-page.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/courses-theme/css/courses-main-theme.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="jspf/teacher-nav-bar.jspf"%>
<div class="banner full-page-height">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div>
                    <div class="page-name"><h2>Students</h2></div>
                    <table id="studentTable" class="table table-hover bg-color-table">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Middle name</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="student" items="${students}">
                                <tr>
                                    <td>${student.id}</td>
                                    <td>${student.user.firstName}</td>
                                    <td>${student.user.lastName}</td>
                                    <td>${student.user.middleName}</td>
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
