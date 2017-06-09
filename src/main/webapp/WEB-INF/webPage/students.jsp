<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Students list</title>

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
<div class="banner">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="intro-message" align="center">

                    <form action="${pageContext.request.contextPath}/student/students" method="get">
                        <input type="submit" value="Update students list" required style="color: #122b40">
                    </form>

                    <table id="studentTable" class="table-bordered" style="background-color: #adadad">
                        <caption style="color: #122b40">
                            <h4>Students</h4>
                        </caption>
                        <tr>
                            <th></th>
                            <th>Id</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Middle name</th>
                        </tr>
                        <c:forEach var="student" items="${students}">
                            <tr>
                                <td>
                                    <input type="radio" name="teacherId" id="${student.id}" value="${student.id}">
                                </td>
                                <td>${student.id}</td>
                                <td>${student.user.firstName}</td>
                                <td>${student.user.lastName}</td>
                                <td>${student.user.middleName}</td>
                            </tr>
                        </c:forEach>
                    </table>

                </div>
            </div>
        </div>
    </div>
    <!-- /.container -->
</div>

</body>
</html>
