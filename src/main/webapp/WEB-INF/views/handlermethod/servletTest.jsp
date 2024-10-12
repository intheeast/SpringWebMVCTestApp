<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Test Servlet Request</title>
</head>
<body>
    <h1>Test Servlet Request with POST</h1>
    <p>Click the button to send a POST request and get the remote address.</p>

    <!-- 버튼을 통해 POST 요청 전송 -->
    <form onsubmit="event.preventDefault(); sendPostRequest();">
        <button type="submit">Send POST Request</button>
    </form>

    <!-- 응답 결과가 표시될 영역 -->
    <div id="result"></div>

    <!-- JavaScript 코드를 페이지 끝에 위치 -->
    <script>
    function sendPostRequest() {
        var url = "/servlet";
        console.log("Sending POST request to:", url);

        // POST 요청을 보냄
        fetch(url, {
            method: 'POST'
        })
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
            console.error('There was a problem with the POST request:', error);
            document.getElementById("result").innerHTML = `<p>Error: ${error.message}</p>`;
        });
    }
    </script>

</body>
</html>
