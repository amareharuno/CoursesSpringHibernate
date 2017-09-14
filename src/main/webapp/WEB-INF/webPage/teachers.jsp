<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Teachers list</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/bootstrapTheme/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/bootstrapTheme/css/landing-page.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/profileStyle.css">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/bootstrapTheme/font-awesome/css/font-awesome.min.css"
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
            <a href="<c:url value="/index"/>" style="color: #5bc0de">Log out</a>
        </div>
    </div>
</div>
<!-- Header -->
<a name="about"></a>
<div class="banner">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="intro-message" align="center">

                    <form action="${pageContext.request.contextPath}/teacher/teachers" method="get">
                        <input type="submit" value="Refresh teachers list" required style="color: #122b40">
                    </form>

                    <table id="teachersTable" class="table-bordered" style="background-color: #adadad">
                        <caption style="color: #122b40">
                            <h2>Teachers</h2>
                        </caption>
                        <tr>
                            <%--<th></th>--%>
                            <th>Id</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Middle name</th>
                        </tr>
                        <c:forEach var="teacher" items="${teachers}">
                            <tr><%--
                                <td>
                                    <input type="radio" name="teacherId" id="${teacher.id}" value="${teacher.id}">
                                </td>--%>
                                <td>${teacher.id}</td>
                                <td>${teacher.user.firstName}</td>
                                <td>${teacher.user.lastName}</td>
                                <td>${teacher.user.middleName}</td>
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
