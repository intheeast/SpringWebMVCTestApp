<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test User ID</title>
</head>
<body>
    <h1>Test User by ID</h1>
    <form action="user" method="get">
        <label for="userId">Enter User ID:</label>
        <input type="text" id="userId" name="userId">
        <button type="button" onclick="fetchUser()">Submit</button>
    </form>
    <h2 id="result"></h2>

    <script>
        function fetchUser() {
            var userId = document.getElementById("userId").value;
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "/user/" + userId, true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    document.getElementById("result").innerHTML = xhr.responseText;
                }
            };
            xhr.send();
        }
    </script>
</body>
</html>