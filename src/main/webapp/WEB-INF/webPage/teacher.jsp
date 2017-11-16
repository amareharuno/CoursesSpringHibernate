<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Teacher</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/bootstrapTheme/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/bootstrapTheme/css/landing-page.css"/>" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/profileStyle.css"/>">

    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/bootstrapTheme/font-awesome/css/font-awesome.min.css"/>"
          rel="stylesheet"
          type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
          rel="stylesheet"
          type="text/css">
</head>
<body>
    <!-- Header -->
    <a name="about"></a>
    <div class="banner">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message" align="center">
                        <h1>Hello, teacher</h1>
                        <h3>Please choose what do you want to do:</h3>
                        <hr class="intro-divider">

                        <div align="center">
                            <form action="<c:url value="/teacher/teachers"/>" method="get">
                                <input type="submit" value="Show teachers" required style="color: #122b40">
                            </form>
                            <form action="<c:url value="/course/coursesToChange"/>" method="get">
                                <input type="submit" value="Show courses" required style="color: #122b40">
                            </form>
                            <form action="<c:url value="/student/students"/>" method="get">
                                <input type="submit" value="Show students" required style="color: #122b40">
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <!-- /.container -->
    </div>
</body>
</html>
