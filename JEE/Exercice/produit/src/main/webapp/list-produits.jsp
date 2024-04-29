<%--

--%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produits</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<h1> La liste de Produits</h1>
<p style="color: blue">${message}</p>
<button type="button" class="btn btn-info">
    <a href="add-produit-form.jsp">Ajouter</a>
</button>
<!-- On tables -->
<table class="table table-light table-striped mt-3">
    <thead>
    <tr>
        <!-- On rows -->

        <th scope="col">Image</th>
        <th scope="col">Marque</th>
        <th scope="col">Reference</th>
        <th scope="col">Prix</th>
        <th scope="col">Stock</th>
        <th scope="col">Détails</th>
        <th scope="col">Supprimer</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${produits}" var="produit">
        <tr>
            <td width="100"><img src="<c:url value="/images/${produit.image}"/>" width="80" height="70"/></td>
            <td>${produit.getMarque()}</td>
            <td>${produit.getReference()}</td>
            <td>${produit.getPrix()} €</td>
            <td>${produit.getStock()}</td>
            <td>
                <button type="button" class="btn">
                    <a href="produitDetail?id=${produit.getId()}">Détails</a>
                </button>
                <button type="button" class="btn">
                    <a href="edit?id=${produit.getId()}">Edit</a>
                </button>
                <button type="button" class="btn ">
                    <a href="produit?id=${produit.getId()}"  class="btn btn-delete">Supprimer</a>
                </button>
            </td>
        </tr>
        <!-- Détails du produit -->

    </c:forEach>

    </tbody>
</table>
<a href="index.jsp">Home Page</a>
<!-- On tables -->

<h2> Liste produits</h2>

           <c:forEach items="${produits}" var="produit">
               <div>
                   Marque    : ${produit.getMarque()}
                   Reférence : ${produit.getReference()}
                   Prix : ${produit.getPrix()}
                   Stock : ${produit.getStock()}

               </div>
           </c:forEach>



</body>
</html>
