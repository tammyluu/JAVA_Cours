<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 24/01/2024
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpLoad</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
    <div>
        <input type="file" name="image"/>
    </div>
    <div>
        <button type="submit" class="btn btn-primary">Charger</button>
    </div>
</form>
</body>
</html>
