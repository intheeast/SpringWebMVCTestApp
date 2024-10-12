<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Test Pet Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
    <h1>This is the Test Pet Page</h1>
    <p>Welcome to the test pet page. This page is rendered from testPet.jsp.</p>

    <form onsubmit="event.preventDefault(); findPet();">
        <label for="petId">Pet ID:</label>
        <input type="text" id="petId" name="petId" required><br><br>

        <button type="submit">Find Pet</button>
    </form>

    <div id="result"></div>
    
	<script>
    function findPet() {
        var petId = document.getElementById("petId").value;

        console.log("Pet ID:", petId);

        if (!petId) {
            alert("Pet ID를 입력하세요.");
            return;
        }

        // URL 생성: petId를 동적으로 URL에 추가
        var url = "/pets/" + petId;
        console.log("Generated URL:", url);

        // fetch 호출 전에 URL을 사용해 GET 요청을 보냄
        fetch(url, {
            method: 'GET',
            headers: {
                'myHeader': 'myValue' // Custom header
            }
        })
        .then(response => {
            console.log("Response received:", response);
            if (!response.ok) {
                throw new Error("HTTP error! Status: " + response.status);
            }
            return response.text();
        })
        .then(data => {
            console.log("Data received from server:", data);
            document.getElementById("result").innerHTML = `<h3>Response from server:</h3><p>${data}</p>`;
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
            document.getElementById("result").innerHTML = `<h3>Error:</h3><p>${error.message}</p>`;
        });
    }
	</script>
	    

</body>
</html>