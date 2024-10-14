<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account Form</title>
</head>
<body>
    <h1>Create Account</h1>
    
    <!-- GlobalControllerAdvice에서 설정된 globalMessage 출력 -->
    <p>${globalMessage}</p>

    <form action="${pageContext.request.contextPath}/model/accounts" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <button type="submit">Submit</button>
    </form>
</body>
</html>