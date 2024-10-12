<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Pet</title>
</head>
<body>
    <h1>Edit Pet</h1>
    <form id="petForm">
        <label for="petId">Pet ID:</label>
        <input type="text" id="petId" name="petId" value="1">
        <br><br>

        <label for="name">Pet Name:</label>
        <input type="text" id="name" name="name" value="Buddy">
        <br><br>

        <label for="type">Pet Type:</label>
        <input type="text" id="type" name="type" value="Dog">
        <br><br>

        <label for="age">Pet Age:</label>
        <input type="number" id="age" name="age" value="5">
        <br><br>

        <button type="button" onclick="submitPetForm()">Submit</button>
    </form>

    <h2>Server Response:</h2>
    <pre id="result"></pre>

    <script>
        function submitPetForm() {
            // Gather form data
            var pet = {
                petId: document.getElementById("petId").value,
                name: document.getElementById("name").value,
                type: document.getElementById("type").value,
                age: document.getElementById("age").value
            };

            // Create XMLHttpRequest object
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/owners/1/pets/1/edit", true);
            xhr.setRequestHeader("Content-Type", "application/json");

            // Handle response
            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    document.getElementById("result").innerText = xhr.responseText;
                }
            };

            // Send JSON data
            xhr.send(JSON.stringify(pet));
        }
    </script>
</body>
</html>