<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Account by Name</title>
</head>
<body>
    <h1>Find Account by Name</h1>

    <form action="${pageContext.request.contextPath}/model/accounts" method="get" onsubmit="event.preventDefault(); goToAccount();">
        <label for="accountName">Account Name:</label>
        <input type="text" id="accountName" name="name" required><br><br>

        <button type="submit">Find Account</button>
    </form>

    <script>
        function goToAccount() {
            var name = document.getElementById("accountName").value;
            if (name) {
                window.location.href = "${pageContext.request.contextPath}/model/accounts/" + encodeURIComponent(name);
            }
        }
    </script>
</body>
</html>