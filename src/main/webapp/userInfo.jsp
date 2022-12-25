<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Users Page</title>
    <link rel="stylesheet" href="https://getbootstrap.com/docs/3.4/examples/signin/signin.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="col-md-offset-2 col-sm-8">
    <div class="page-header">
        <h1>Welcome On Users Info Page</h1>
    </div>
    <h4 class="form-signin-heading">Users info</h4>
    <table class="table table-sub-heading-color">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Email</th>
            <th scope="col">Login</th>
            <th scope="col">Full Name</th>
        </tr>
        </thead>
        <c:forEach var="user" items="${userInfo}">
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.login}</td>
                <td>${user.fullName}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="<c:url value="/home"/>" class="btn btn-primary btn-lg active">Home Page</a>
    <a href="<c:url value="/logout"/>" class="btn btn-primary btn-lg active">Logout</a>
</div>
</body>
</html>
