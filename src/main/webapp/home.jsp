<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home Page</title>
    <link rel="stylesheet" href="https://getbootstrap.com/docs/3.4/examples/signin/signin.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="col-md-offset-2 col-sm-8">
    <div class="page-header">
        <h1>Welcome On Home Page</h1>
    </div>
    <a href="<c:url value="/userInfo"/>" class="btn btn-primary btn-lg active">User info</a>
    <a href="<c:url value="/logout"/>" class="btn btn-primary btn-lg active">Logout</a>
</div>

</body>
</html>