<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Teacher</title>

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
                    <h1>Hello, teacher</h1>
                    <h3>Please choose what do you want to do:</h3>
                    <hr class="intro-divider">

                    <div>
                        <form action="<c:url value="/teacher/teachers"/>" method="get">
                            <input type="submit" value="Show teachers" class="btn btn-default btn-lg">
                        </form>
                        <form action="<c:url value="/course/coursesToChange"/>" method="get">
                            <input type="submit" value="Show courses" class="btn btn-default btn-lg">
                        </form>
                        <form action="<c:url value="/student/students"/>" method="get">
                            <input type="submit" value="Show students" class="btn btn-default btn-lg">
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
