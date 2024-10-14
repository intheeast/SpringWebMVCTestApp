<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account Details</title>
</head>
<body>
    <h1>Account Details</h1>
    
    <!-- GlobalControllerAdvice에서 설정된 globalMessage 출력 -->
    <p>${globalMessage}</p>
    
    <p><strong>Account Name:</strong> ${myAccount.name}</p>
    <p><strong>Account Email:</strong> ${myAccount.email}</p>
    
    <a href="/accounts">Go Back</a>
</body>
</html>