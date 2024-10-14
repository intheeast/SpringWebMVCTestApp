<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>People List</title>
</head>
<body>
<h1>People List</h1>
<ul>
    <c:forEach var="person" items="${people}">
        <li>${person.name} (ID: ${person.id})</li>
    </c:forEach>
</ul>
</body>
</html>