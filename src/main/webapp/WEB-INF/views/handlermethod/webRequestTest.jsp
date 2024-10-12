<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Test WebRequest</title>
</head>
<body>
    <h1>Test WebRequest with GET Parameter</h1>
    <p>Enter a parameter value and submit to send a GET request:</p>

    <!-- 파라미터 입력 폼 -->
    <form onsubmit="event.preventDefault(); sendWebRequest();">
        <label for="paramName">Parameter Name:</label>
        <input type="text" id="paramName" name="paramName" required>
        <button type="submit">Send GET Request</button>
    </form>

    <!-- 응답 결과가 표시될 영역 -->
    <div id="result"></div>

    <!-- JavaScript 코드를 페이지 끝에 위치 -->
    <script>
    function sendWebRequest() {
        var paramValue = document.getElementById("paramName").value;

        // GET 요청에 파라미터를 포함한 URL 생성
    	var url = "/webrequest?paramName=" + encodeURIComponent(paramValue);
        console.log("Sending GET request to:", url);

        // GET 요청을 보냄
        fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error! Status: " + response.status);
            }
            return response.text();
        })
        .then(data => {
            console.log("Data received from server:", data);

            // 결과를 페이지에 표시
            document.getElementById("result").innerHTML = `<h3>Response from server:</h3><p>${data}</p>`;
        })
        .catch(error => {
            console.error('There was a problem with the GET request:', error);
            document.getElementById("result").innerHTML = `<p>Error: ${error.message}</p>`;
        });
    }
    </script>

</body>
</html>