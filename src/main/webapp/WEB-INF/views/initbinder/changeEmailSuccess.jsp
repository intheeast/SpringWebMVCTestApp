<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <title>Email Change Result</title>
</head>
<body>
    <h2>Email Change Result</h2>

    <!-- 모델에서 전달된 메시지 출력 -->
    <p>${message}</p>

    <!-- 허용되지 않은 필드 무시 메시지 출력 -->
    <c:if test="${not empty unauthorizedMessage}">
        <p>${unauthorizedMessage}</p>
    </c:if>
    
    <a href="<c:url value='/tests/initbinderonlyfields' />">Change another email</a>
</body>
</html>