<%--

--%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creation de Personne</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2>Formulaire de création d'une personne</h2>
    <form action="personne" method="post">
        <div class="mb-3">
            <label for="nom" class="form-label">Nom : </label>
            <input type="text" class="form-control" id="nom" name="nom"></div>
        <div class="mb-3">
            <label for="prenom" class="form-label">Prénom :</label>
            <input type="text" class="form-control" id="prenom" name="prenom">
        </div>
        <button type="submit" class="btn btn-primary">Créer</button>
    </form>
</div>
</body>
</html>
