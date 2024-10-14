<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Account Form</title>
</head>
<body>
    <h2>Account Form</h2>
	<form action="${pageContext.request.contextPath}/valid/accounts" method="post">
        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" />
            <c:if test="${not empty errors['username']}">
                <div style="color: red;">${errors['username'].defaultMessage}</div>
            </c:if>
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" />
            <c:if test="${not empty errors['email']}">
                <div style="color: red;">${errors['email'].defaultMessage}</div>
            </c:if>
        </div>
        <button type="submit">Submit</button>
    </form>
</body>
</html>