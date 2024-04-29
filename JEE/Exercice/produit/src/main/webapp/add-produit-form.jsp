<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 23/01/2024
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un produit</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2>Formulaire de création d'un produit</h2>

    <form action="produit" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label for="marque" class="form-label">Marque : </label>
            <input type="text" class="form-control" id="marque" name="marque"></div>
        <div class="mb-3">
            <label for="reference" class="form-label">Reférence :</label>
            <input type="text" class="form-control" id="reference" name="reference">
        </div>

        <div class="mb-3">
            <label for="prix" class="form-label">Prix unitaire :</label>
            <input type="number" class="form-control" id="prix" name="prix">
        </div>
        <div class="mb-3">
            <label for="stock" class="form-label">Stock :</label>
            <input type="number" class="form-control" id="stock" name="stock">
        </div>
        <div class="mb-3">
            Select : <input type="file" name="image" size="60" /><br /><br />
            <button type="submit" class="btn btn-primary">Upload</button>
        </div>

        <button type="submit" class="btn btn-primary">Créer</button><br>

        <a href="produit">Liste de produits</a>
    </form>
</div>
</body>
</html>
