<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Teachers list</title>

    <link href="<c:url value="/resources/bootstrapTheme/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrapTheme/css/landing-page.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/courses-theme/css/courses-main-theme.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="banner full-page-height">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div>
                    <div class="page-name"><h2>Teachers</h2></div>

                    <table id="teachersTable" class="table table-hover bg-color-table">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Middle name</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="teacher" items="${teachers}">
                            <tr>
                                <td>${teacher.id}</td>
                                <td>${teacher.user.firstName}</td>
                                <td>${teacher.user.lastName}</td>
                                <td>${teacher.user.middleName}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                    <form action="<c:url value="/teacher/teachers"/>" method="get">
                        <button type="submit" class="btn btn-default btn-lg">Refresh teachers list</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
