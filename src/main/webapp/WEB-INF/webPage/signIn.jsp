<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sign in</title>

    <link href="<c:url value="/resources/bootstrapTheme/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrapTheme/css/landing-page.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/courses-theme/css/courses-main-theme.css"/>" rel="stylesheet" type="text/css">
</head>

<body>
<div class="intro-header full-page-height">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div>
                    <h1>Sign in to Courses</h1>
                    <h3>Please enter your login and password</h3>
                    <hr class="intro-divider">

                    <div class="warning-text">${somethingWrongSignInMessage}</div>

                    <form class="list-inline form-group"
                          action="<c:url value="/signedInUser"/>" method="post">

                        <input type="hidden" name="command" value="login">

                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <input class="form-control lead" type="text" name="login" placeholder="Login">
                        </div>
                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <input class="form-control lead" type="password" name="password" placeholder="Password">
                        </div>

                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <button class="btn btn-default btn-lg" type="submit">Sign in</button>
                            <p class="network-name">
                                <br>
                                New to Courses?
                                <a href="<c:url value="/signUp"/>" class="color-link">
                                    <u>Sign Up</u>
                                </a>
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
