<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Error Occurred</h1>

    <p>There were errors in your form submission. Please try again.</p>

    <a href="${pageContext.request.contextPath}/pet/${pet.petId}/edit">Go back to Edit Pet</a>
</body>
</html>