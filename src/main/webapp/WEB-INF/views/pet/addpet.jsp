<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Pet</title>
    <!-- 공통 CSS 파일을 불러오는 부분 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
    <h2>Add a New Pet</h2>
    <form onsubmit="event.preventDefault(); submitPetForm();">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="type">Type:</label>
        <input type="text" id="type" name="type" required><br><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br><br>

        <button type="submit">Submit</button>
    </form>

	 
    
	
    <!-- JavaScript는 body 끝부분에 위치 -->
    <script>
    function submitPetForm() {
        var pet = {
            name: document.getElementById("name").value,
            type: document.getElementById("type").value,
            age: document.getElementById("age").value
        };

        // 팝업창을 먼저 열어두고 데이터는 나중에 삽입
        var popup = window.open("", "Pet Info", "width=400,height=400");

        // 팝업 창이 열렸는지 확인
        if (!popup || popup.closed || typeof popup.closed == 'undefined') {
            alert('Popup was blocked! Please allow popups for this website.');
            return;
        }

        console.log("Popup opened successfully.");

        // 팝업 창에 기본적인 HTML 템플릿을 먼저 삽입
        popup.document.body.innerHTML = `
            <html>
            <head>
                <title>Pet Information</title>
            </head>
            <body>
                <h3>Loading pet information...</h3>
            </body>
            </html>
        `;

        fetch('/pets', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(pet)
        })
        .then(response => {
            console.log("Response received:", response);
            if (!response.ok) {
                throw new Error("HTTP error! Status: " + response.status);
            }
            return response.json(); // 응답을 JSON으로 변환
        })
        .then(data => {
            console.log("Data received from server:", data);

            // 팝업 창에 DOM 조작으로 데이터를 삽입
            popup.document.body.innerHTML = `
                <h3>Pet Information:</h3>
                <p><strong>Name:</strong> ${data.name}</p>
                <p><strong>Type:</strong> ${data.type}</p>
                <p><strong>Age:</strong> ${data.age}</p>
            `;
        })
        .catch(error => {
            console.error('Error:', error);

            // 팝업 창에 에러 메시지를 DOM 조작으로 표시
            popup.document.body.innerHTML = `
                <h3>Failed to load pet information</h3>
                <p>Error: ${error.message}</p>
            `;
        });
    }
    </script>
</body>
</html>