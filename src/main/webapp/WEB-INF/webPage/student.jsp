<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student</title>

    <link href="<c:url value="/resources/bootstrapTheme/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrapTheme/css/landing-page.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/courses-theme/css/courses-main-theme.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="banner intro-header full-page-height">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div>
                    <h1>Hello, student</h1>
                    <h3>Please choose what do you want to do:</h3>
                    <hr class="intro-divider">

                    <div>
                        <form action="<c:url value="/teacher/teachers"/>" method="get">
                            <button type="submit" class="btn btn-default btn-lg">Show teachers</button>
                        </form>
                        <form action="<c:url value="/course/courses"/>" method="get">
                            <button type="submit" class="btn btn-default btn-lg">Show courses</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /.container -->
</div>
<!-- /.intro-header -->
</body>
</html>

