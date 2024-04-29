<%--

--%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person</title>
</head>
<body>
<h1> La liste de personnes</h1>

<c:forEach items="${personnes}" var="personne">
    <div>
        Nom    : ${personne.getNom()}
        Prenom : ${personne.getPrenom()}
            <%-- personne vient de var --%>
        <a href="personne?nom=${personne.getNom()}">Details</a>
    </div>
</c:forEach>

</body>
</html>
