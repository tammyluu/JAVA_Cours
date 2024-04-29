
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PATIENT ${patient.getId()}</title>
    <jsp:include page="../../includes/head.jsp" />
</head>
<body>
<jsp:include page="../../includes/header.jsp" />
<div class="container d-flex flex-column justify-content-center h-100 w-50">
    <center>
        <div class="card" style="width: 18rem;">
            <img src="${pageContext.request.contextPath}/imageServlet?id=${patient.getId()}" class="card-img-top img-thumbnail" alt="Photo of patient">
            <div class="card-body">
                <h5 class="card-title">Patient : ${patient.getLastName()}  ${patient.getFirstName()}</h5>

            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item"> Fist name: ${patient.getFirstName()} </li>
                <li class="list-group-item">Last name : ${patient.getLastName()} €</li>
                <li class="list-group-item"> Birthday : ${patient.getDateOfBirth()}</li>

            </ul>
            <div class="card-body">
                <a href="list" class="btn btn-primary">Return</a>
                <a href="delete?id=${patient.getId()}" class="btn btn-danger">Delete</a>
            </div>

        </div>
    </center>
</div>
</body>
</html>
