<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Test OPTIONS Request for Pet</title>
</head>
<body>
    <h1>Test OPTIONS Request for Pet Endpoint</h1>
    <p>Enter the Pet ID and submit to send an OPTIONS request:</p>

    <!-- Pet ID 입력 폼 -->
    <form onsubmit="event.preventDefault(); sendOptionsRequest();">
        <label for="petId">Pet ID:</label>
        <input type="text" id="petId" name="petId" required>
        <button type="submit">Send OPTIONS Request</button>
    </form>

    <!-- 응답 결과가 표시될 영역 -->
    <div id="result"></div>

    <!-- JavaScript 코드를 페이지 끝에 위치 -->
    <script>
    function sendOptionsRequest() {
        var petId = document.getElementById("petId").value;

        // Pet ID를 포함한 URL 생성
        var url = "/pets/" + petId;
        console.log("Sending OPTIONS request to:", url);

        // OPTIONS 요청을 보냄
        fetch(url, {
            method: 'OPTIONS'
        })
        .then(response => {
            console.log("Response Headers:");
            console.log(response.headers);

            // Allow 헤더 가져오기 (지원되는 메서드)
            let allowedMethods = response.headers.get('Allow');

            // 결과를 페이지에 표시
            document.getElementById("result").innerHTML = `
                <h3>Supported Methods:</h3>
                <p><strong>Allow:</strong> ${allowedMethods}</p>
            `;
        })
        .catch(error => {
            console.error('There was a problem with the OPTIONS request:', error);
            document.getElementById("result").innerHTML = `<p>Error: ${error.message}</p>`;
        });
    }
    </script>

</body>
</html>
