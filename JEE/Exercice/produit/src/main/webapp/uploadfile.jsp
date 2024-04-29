<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 24/01/2024
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div>
    <h1>Upload file in servlet</h1>
    <form method="post" action="upload" enctype="multipart/form-data">
        Select file to upload: <input type="file" name="image" size="60" /><br /><br />
        <button type="submit" class="btn btn-primary">Upload</button>

    </form>
</div>
</body>
</html>
