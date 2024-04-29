<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Patient</title>
    <jsp:include page="../../includes/head.jsp" />

</head>
<body>
<jsp:include page="../../includes/header.jsp"/>
<div class="container mt-4">
    <center>
        <c:if test="${patient == null}">
            <h2>Ajouter un patient </h2>
        </c:if>
        <c:if test="${patient != null}">
            <h2>Modifier un patient </h2>
        </c:if>
    </center>
    </center>
    <div>
        <form action="insert" method="post" enctype="multipart/form-data">
            <div class="form-row">
                <c:if test="${patient != null}">
                    <input type="hidden" name="id" value="<c:out value='${patient.getId()}' />" />
                </c:if>
                <div class="form-group col-md-6">
                    <label for="lastName">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" value="${patient.getLastName()}">
                </div>
                <div class="form-group col-md-6">
                    <label for="firstName">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" value="${patient.getFristName()}">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="dateOfBirth">Date Of Birth</label>
                    <input type="text" class="form-control" id="dateOfBirth" placeholder="12" name="dateOfBirth" value="${patient.getDateOfBirth()}">
                </div>

            </div>
            <div class="form-row">
                <div class="mb-3">
                    <label for="formFile" class="form-label">Photo</label>
                    <input class="form-control" type="file" id="formFile" name="image" accept=".png" >
                </div>
            </div>
            <button type="submit" class="btn btn-primary">${patient == null ? 'Validation' : 'Update'}</button>
        </form>
    </div>
</div>
</body>
</html>
