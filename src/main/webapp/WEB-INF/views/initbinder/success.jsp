<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Form Submission Success</title>
</head>
<body>
    <h2>Form Submission Successful!</h2>

    <!-- 모델로 전달된 Date 객체를 지정된 형식으로 출력 -->
    <p>You submitted the following date: 
        <fmt:formatDate value="${submittedDate}" pattern="yyyy-MM-dd" />
    </p>
    
    <a href="/initbinder/showForm">Go back to form</a>
</body>
</html>