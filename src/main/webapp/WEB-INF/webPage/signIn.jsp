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

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/bootstrapTheme/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/bootstrapTheme/css/landing-page.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/bootstrapTheme/font-awesome/css/font-awesome.min.css"
          rel="stylesheet"
          type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
          rel="stylesheet"
          type="text/css">
</head>

<body>
<!-- Header -->
<a name="about"></a>
<div class="intro-header">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="intro-message">
                    <h1>Sign in to Courses</h1>
                    <h3>Please enter your login and password</h3>
                    <hr class="intro-divider">

                    <%--SIGN IN FORM--%>
                    <form class="list-inline" action="${pageContext.request.contextPath}/signedInUser">
                        <input type="hidden" name="command" value="login">
                        <p>
                            <input class="lead" type="text" required style="color: #122b40"
                                   name="login" placeholder="Login">
                            <br>
                            <input class="lead" type="password" required style="color: #122b40"
                                   name="password" placeholder="Password">
                        </p>
                        <p>
                            <input class="btn btn-default btn-lg"
                                   type="submit" value="Sign in">
                        </p>
                    </form>
                    <%------------------%>

                    <p class="network-name">
                        <br>
                        New to Courses?
                        <a href="<c:url value="/signUp"/>" style="color: #5bc0de">
                            <u>Sign Up</u>
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
