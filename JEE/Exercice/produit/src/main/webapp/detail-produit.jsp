
<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 23/01/2024
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail de produit</title>
</head>
<body>
<h1>>>Detail d'un produit</h1>
<form action="produitDetail">
    <label>Image: </label>
    <c:if test="${Produit.image != null}">
        <img src="<c:url value="/images/${Produit.image}"/>"width="80" height="70" >
    </c:if>
   ${produit.getImage()}<br>
    <label>Marque: </label>
   ${produit.getMarque()}<br>
    <label>Référence: </label>
    ${produit.getReference()}<br>
    <label>Prix unitaire:  </label>
    ${produit.getPrix()} €<br>
    <label>Stock </label>
   ${produit.getStock()}
</form>






</body>
</html>
