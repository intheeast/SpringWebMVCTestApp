<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test RequestAttributeController</title>
</head>
<body>
    <h1>Test RequestAttributeController</h1>

    <p>Click the button to test the /client endpoint.</p>
    <button type="button" id="testButton">Send Request</button>  <!-- 버튼에 id 추가 -->

    <h2>Result:</h2>
    <div id="result">Result will be displayed here</div>

    <!-- 자바스크립트 코드를 body 끝에 배치 -->
    <script>
        // 페이지가 모두 로드된 후에 이벤트 리스너를 추가하여 버튼 클릭 시 sendRequest 호출
        document.addEventListener("DOMContentLoaded", function() {
            // 버튼 클릭 이벤트 리스너 추가
            document.getElementById("testButton").addEventListener("click", sendRequest);
        });

        function sendRequest() {
            console.log("sendRequest function called");  // 함수 호출 확인용 로그

            var xhr = new XMLHttpRequest();
            xhr.open("GET", "/client", true);  // /client 엔드포인트로 GET 요청
            xhr.setRequestHeader("Content-Type", "application/json");

            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    document.getElementById("result").innerHTML = xhr.responseText;
                } else if (xhr.readyState === 4 && xhr.status !== 200) {
                    document.getElementById("result").innerHTML = "Error occurred: " + xhr.status;
                }
            };

            xhr.send();  // 요청 전송
        }
    </script>
</body>
</html>