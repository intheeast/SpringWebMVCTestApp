<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Test Session Handling</title>
</head>
<body>
    <h1>Test Session Handling with Separate Buttons</h1>
    <p>Enter a username and use the buttons below to set and get session attributes:</p>

    <!-- 입력 폼 -->
    <form id="setSessionForm" onsubmit="event.preventDefault(); setSession();">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <button type="submit">Set Session Attribute (username)</button>
    </form>
    <br>

    <!-- Get Attribute 버튼 -->
    <form onsubmit="event.preventDefault(); getSessionAttribute();">
        <button type="submit">Get Session Attribute (username)</button>
    </form>

    <!-- 응답 결과가 표시될 영역 -->
    <div id="result"></div>

    <!-- JavaScript 코드를 페이지 끝에 위치 -->
    <script>
    // 세션에 "username" 값을 설정하는 POST 요청
    function setSession() {
        var form = document.getElementById('setSessionForm');
        var formData = new FormData(form);
        var url = "/session-set";
        console.log("Sending POST request to set session:", url);

        // POST 요청을 보냄
        fetch(url, {
            method: 'POST',
            body: formData
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error! Status: " + response.status);
            }
            return response.text();
        })
        .then(data => {
            console.log("Session set response:", data);

            // 결과를 페이지에 표시
            document.getElementById("result").innerHTML = `<h3>Session Set:</h3><p>${data}</p>`;
        })
        .catch(error => {
            console.error('There was a problem with the POST request:', error);
            document.getElementById("result").innerHTML = `<p>Error: ${error.message}</p>`;
        });
    }

    // 세션에서 "username" 값을 가져오는 요청
    function getSessionAttribute() {
        var url = "/session-get";
        console.log("Sending GET request to retrieve session attribute:", url);

        // 세션에서 username 값을 가져오는 GET 요청
        fetch(url, {
            method: 'GET'
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error! Status: " + response.status);
            }
            return response.text();
        })
        .then(data => {
            console.log("Session get response:", data);

            // 결과를 페이지에 표시
            document.getElementById("result").innerHTML = `<h3>Session Get Response:</h3><p>${data}</p>`;
        })
        .catch(error => {
            console.error('There was a problem with the GET request:', error);
            document.getElementById("result").innerHTML = `<p>Error: ${error.message}</p>`;
        });
    }
    </script>

</body>
</html>