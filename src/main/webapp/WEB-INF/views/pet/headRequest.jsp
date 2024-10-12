<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pet Info Head Request</title>
</head>
<body>
    <h1>Send HEAD Request for Pet Info</h1>
    <p>Enter the Pet ID and submit to send a HEAD request:</p>

    <!-- Pet ID 입력 폼 -->
    <form onsubmit="event.preventDefault(); sendHeadRequest();">
        <label for="petId">Pet ID:</label>
        <input type="text" id="petId" name="petId" required>
        <button type="submit">Send HEAD Request</button>
    </form>

    <!-- 응답 결과가 표시될 영역 -->
    <div id="result"></div>

    <!-- JavaScript 코드는 페이지 끝에 위치 -->
    <script>
    function sendHeadRequest() {
        var petId = document.getElementById("petId").value;

        // Pet ID를 포함한 URL 생성
        var url = "/pets/" + petId;
        console.log("Sending HEAD request to:", url);

        // HEAD 요청을 보냄
        fetch(url, {
            method: 'HEAD'
        })
        .then(response => {
            console.log("Response Headers:");
            console.log(response.headers);

            // Content-Length 헤더 가져오기
            let contentLength = response.headers.get('Content-Length');
            let contentType = response.headers.get('Content-Type');

            // 결과를 페이지에 표시
            document.getElementById("result").innerHTML = `
                <h3>Response Headers:</h3>
                <p><strong>Content-Length:</strong> ${contentLength}</p>
                <p><strong>Content-Type:</strong> ${contentType}</p>
            `;
        })
        .catch(error => {
            console.error('There was a problem with the HEAD request:', error);
            document.getElementById("result").innerHTML = `<p>Error: ${error.message}</p>`;
        });
    }
    </script>

</body>
</html>
