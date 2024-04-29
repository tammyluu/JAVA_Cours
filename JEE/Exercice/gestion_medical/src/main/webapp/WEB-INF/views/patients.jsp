<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produits</title>
    <jsp:include page="../../includes/head.jsp" />

</head>
<body>
<jsp:include page="../../includes/header.jsp"/>
<div class="container mt-4">
    <center>
        <h2>List of Patients </h2>
    </center>
    <div class="m-4">
        <a href="new" class="btn btn-success text-start">Add Patient </a>
    </div>


    <center>
        <table border="1" cellpadding="5" class="table table-dark text-center" >

            <tr>
                <th>Id</th>
                <th>Photo</th>
                <th>Last name</th>
                <th>First name</th>
                <th>Date of birth</th>
                <th >Actions</th>
            </tr>
            <c:choose>
                <c:when test="${patients != null}">
                    <c:forEach items="${patients}" var="patient">
                        <tr>
                            <td>${patient.getId()}</td>
                            <td> <img src="${pageContext.request.contextPath}/imageServlet?id=${patient.getId()}" class="img-thumbnail" style="width: 50px;height: 50px;" alt="Image"></td>
                            <td>${patient.getLastName()}</td>
                            <td>${patient.getFirstName()}</td>
                            <td>${patient.getDateOfBirth()} </td>
                            <td>
                                <a href="edit?id=${patient.getId()}" class="btn btn-info">Edit</a>
                                <a href="delete?id=${patient.getId()}" class="btn btn-danger">Delete</a>
                                <a href="details?id=${patient.getId()}" class="btn btn-primary">Detail</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <!-- Votre code HTML ou JSP pour le cas où patients est null -->
                    <tr><td colspan="6">Patient not found.</td></tr>
                </c:otherwise>
            </c:choose>

        </table>
    </center>
</div>


</body>
</html>
