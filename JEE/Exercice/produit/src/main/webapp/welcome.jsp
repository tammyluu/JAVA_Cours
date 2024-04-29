<%--
 hange this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<form action="produitDetail">
    <label>Welcome: </label>
    ${produit.getMarque()}<br>
<form action="register"  >
    <h2>Welcome to our site ${user.getName()}</h2>

</form>

<a href="LogoutServlet">Logout</a>
</body>
</html>
