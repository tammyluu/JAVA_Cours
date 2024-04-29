<%--
  Created by IntelliJ IDEA.
  User: luuta
  Date: 1/24/2024
  Time: 1:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Afficher la liste des produits dont le prix est supérieur à 20 euros</h2>
<table class="table table-light table-striped mt-3">
    <thead>
    <tr>
        <!-- On rows -->

        <th scope="col">Marque</th>
        <th scope="col">Reference</th>
        <th scope="col">Prix</th>
        <th scope="col">Stock</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${prodFiltre}" var="produit">
        <tr>
            <td>${produit.getMarque()}</td>
            <td>${produit.getReference()}</td>
            <td>${produit.getPrix()} €</td>
            <td>${produit.getStock()}</td>

        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
