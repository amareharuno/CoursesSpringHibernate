<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Courses Spring</title>

    <link href="<c:url value="/resources/bootstrapTheme/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrapTheme/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet"
          type="text/css">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/courses-theme/css/courses-main-theme.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrapTheme/css/landing-page.css"/>" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet"
          type="text/css">
</head>

<body>
<div class="intro-header">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="intro-message">
                    <h1>Welcome to Courses!</h1>
                    <h3>It's time to begin</h3>
                    <hr class="intro-divider">
                    <ul class="list-inline intro-social-buttons">
                        <li>
                            <a class="btn btn-default btn-lg" href="<c:url value="/signIn"/>">
                                <span class="network-name">Sign in</span>
                            </a>
                        </li>
                        <li>
                            <a class="btn btn-default btn-lg" href="<c:url value="/signUp"/>">
                                <span class="network-name">Sign up</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Page Content -->
<div class="content-section-a">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-sm-6">
                <h2 class="section-heading">This project was created<br>for BSUIR "App Development in Java" course.</h2>
                <hr class="section-heading-spacer">
                <div class="clearfix"></div>
                <p class="lead">
                    <u>The TASK of COURSES project:</u> <br>
                    - There is a list of courses. One teacher is assigned for each course. <br>
                    - A student can see a list of courses and teachers. <br>
                    - A teacher can edit information about courses (teacher can add course, delete it or update).
                </p>
            </div>

            <div class="col-lg-5 col-lg-offset-1 col-sm-6">
                <img class="img-responsive" src="<c:url value="/resources/bootstrapTheme/img/ipad.png"/>" alt="">
            </div>
        </div>
    </div>
</div>

<div class="banner">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <h2>Find out project files here:</h2>
            </div>

            <div class="col-lg-6">
                <ul class="list-inline banner-social-buttons">
                    <li>
                        <a href="https://github.com/amareharuno/courses" class="btn btn-default btn-lg">
                            <i class="fa fa-github fa-fw"></i>
                            <span class="network-name">Github</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <p class="copyright text-muted small">
                    &copy; BSUIR 2017, Faculty of Computer Aided Design, Programmable Mobile Systems. Lyuba Eremeeva.
                </p>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
