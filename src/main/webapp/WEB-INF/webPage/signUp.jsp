<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Sign up</title>

    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrapTheme/css/landing-page.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/courses-theme/css/courses-main-theme.css"/>" rel="stylesheet">

    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
</head>

<body>
<div class="intro-header full-page-height">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div>
                    <h1>Sign up to Courses</h1>
                    <h3>Create your personal account</h3>
                    <hr class="intro-divider">

                    <label class="warning-text">${somethingWrongSignUpMessage}</label>

                    <form id="signUpForm"
                          class="list-inline form-group"
                          action="<c:url value="/signedUpUser"/>" method="post">

                        <input type="hidden" name="command" value="register">

                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <input class="form-control lead" type="text" name="firstName" placeholder="First name" required>
                        </div>

                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <input class="form-control lead" type="text" name="lastName" placeholder="Last name" required>
                        </div>

                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <input class="form-control lead" type="text" name="middleName" placeholder="Middle name" required>
                        </div>

                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <input class="form-control lead" type="text" name="login" placeholder="Login" required>
                        </div>

                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <input class="form-control lead" type="password" name="password" placeholder="Password" required>
                        </div>

                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <label>
                                <span>Are you a teacher or a student?</span>
                                <br>
                                <select class="form-control lead" name="role" form="signUpForm">
                                    <option selected class="lead" value="teacher">Teacher</option>
                                    <option class="lead" value="student">Student</option>
                                </select>
                            </label>
                        </div>

                        <div class="col-lg-offset-4 col-lg-4 col-lg-offset-4">
                            <button class="btn btn-default btn-lg" type="submit">Create an account</button>
                            <br>
                            <span class="network-name">
                                <br>
                                I have an account.
                                <a href="<c:url value="/signIn"/>" class="color-link">Sign In</a>
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
