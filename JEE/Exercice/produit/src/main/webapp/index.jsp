<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="com.example.produit.servlet.Constants" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.produit.servlet.Constants" %>

<!DOCTYPE html>
<html>
<head>
    <title>Produits</title>
</head>
<body>
<h1><%= "HomePage" %></h1>
<br/>

<%--<%
    HttpSession session1 = request.getSession();
    Object usernameObj = session1.getAttribute(Constants.USER_LOGGED);
    String username = (usernameObj != null) ? usernameObj.toString() : null;
    String contextPath = request.getContextPath();

    if (username != null && username.length() > 0) {
        // Utilisateur connecté
        out.print("<a href='" + contextPath + "/logout'>LOG OUT </a>");
    } else {
        // Utilisateur non connecté
        out.print("<a href='" + contextPath + "/login-form'>LOG IN </a>");
    }
%>--%>

<c:choose>
    <c:when test="${not empty username}">
        <a href='<c:url value="${contextPath}/logout" />'>LOG OUT </a>
    </c:when>
    <c:otherwise>
        <a href='<c:url value="${contextPath}/login" />'>LOG IN </a><br>
    </c:otherwise>
</c:choose>

<a href="produit">Liste de produits</a><br>
<a href="add-produit-form.jsp">Ajouter un produit</a><br>
<a href="by-price.jsp">Filtre produit > 20 €</a><br>
<a href="login-form.jsp">LOGIN </a><br>
<a href="register.jsp">Register</a><br>
<a href="uploadfile.jsp">Upload File</a>
</body>
</html>
