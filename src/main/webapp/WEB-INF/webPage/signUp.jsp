<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Sign up</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/bootstrapTheme/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/myCss.css"/>">
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
<div class="header_back">
    <div class="header">
        <div class="logo_pic">
            <a href="<c:url value="/index"/>" style="color: #5bc0de">Back to main page</a>
        </div>
    </div>
</div>
<!-- Header -->
<a name="about"></a>
<div class="intro-header">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="intro-message">
                    <h1>Sign up to Courses</h1>
                    <h3>Create your personal account</h3>
                    <hr class="intro-divider">
                    <label style="color: yellow; size: 26pt">${somethingWrongSignUpMessage}</label>
                    <form id="signUpForm" class="list-inline" action="<c:url value="/signedUpUser"/>" method="post">
                        <p>
                            <input type="hidden"
                                   name="command" value="register">
                            <input class="lead" type="text"
                                   name="firstName" placeholder="First name"
                                   required style="color: #122b40">
                            <br>
                            <input class="lead" type="text"
                                   name="lastName" placeholder="Last name"
                                   required style="color: #122b40">
                            <br>
                            <input class="lead" type="text"
                                   name="middleName" placeholder="Middle name"
                                   required style="color: #122b40">
                            <br>

                            <br>
                            <input class="lead" type="text"
                                   name="login" placeholder="Login"
                                   required style="color: #122b40">
                            <br>
                            <input class="lead" type="password"
                                   name="password" placeholder="Password"
                                   required style="color: #122b40">
                            <br>
                            <select class="lead" name="role" form="signUpForm" required style="color: #122b40">
                                <option selected class="lead" value="teacher">Teacher</option>
                                <option class="lead" value="student">Student</option>
                            </select>
                        </p>
                        <p>
                            <input class="btn btn-default btn-lg" type="submit"
                                   value="Create an account">
                        </p>
                        <%--
                        <label>
                            <input type="checkbox" name="role">
                            I'm a teacher.
                        </label>
                        --%>
                    </form>

                    <p class="network-name">
                        <br>
                        I have an account.
                        <a href="<c:url value="/signIn"/>" style="color: #5bc0de">
                            <u>Sign In</u>
                        </a>
                    </p>
                </div>
            </div>
        </div>
    </div>
    <!-- /.container -->
</div>
<!-- /.intro-header -->
</body>

</html>
