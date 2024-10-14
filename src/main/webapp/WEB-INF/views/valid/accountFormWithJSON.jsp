<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Form</title>
    <!-- 스타일 시트 경로 수정 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <h2>User Form</h2>
    <form onsubmit="event.preventDefault(); sendUserData();">
        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username"/>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"/>
        </div>
        <button type="submit">Submit</button>
    </form>

    <!-- 서버 응답을 표시하는 영역 -->
    <div id="response"></div>

    <!-- 스크립트는 <body> 태그 아래에 두어야 함 -->
    <script>
        function sendUserData() {
            console.log("sendUserData 함수가 호출되었습니다.");
            // 사용자 입력값을 가져옵니다.
            const username = document.getElementById("username").value;
            const password = document.getElementById("password").value;

            console.log("사용자 입력 - Username:", username, "Password:", password);

            // JSON 객체 생성
            const userData = {
                username: username,
                password: password
            };

            // XMLHttpRequest를 사용하여 POST 요청 보내기
            const xhr = new XMLHttpRequest();
            xhr.open("POST", "${pageContext.request.contextPath}/valid/users", true); // POST 요청
            xhr.setRequestHeader("Content-Type", "application/json"); // JSON 데이터 전송

            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    // 성공적으로 전송 후 응답 받았을 때 처리
                    document.getElementById("response").innerText = xhr.responseText;
                } else if (xhr.readyState === 4 && xhr.status !== 200) {
                    // 오류 발생 시 처리
                    document.getElementById("response").innerText = "Error: " + xhr.responseText;
                }
            };

            // JSON 데이터를 문자열로 변환하여 전송
            xhr.send(JSON.stringify(userData));
        }
    </script>
</body>
</html>