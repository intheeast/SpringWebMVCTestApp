<!DOCTYPE html>
<html>
<head>
    <title>Email Change Result</title>
</head>
<body>
    <h2>Email Change Result</h2>

    <!-- 모델에서 전달된 메시지 출력 -->
    <p>${message}</p>
    
    <!-- 다시 이메일을 변경할 수 있는 링크 -->
    <a href="<c:url value='/tests/initbinderwithcb' />">Change another email</a>
</body>
</html>