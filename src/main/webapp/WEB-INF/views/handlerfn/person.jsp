<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person Management</title>
</head>
<body>
    <h1>Person Management</h1>

    <!-- 모든 사람 목록 보기 -->
    <h2>All People</h2>
    <button onclick="fetchPeople()">Load People</button>
    <div id="peopleList"></div>

    <!-- 특정 사람 조회 -->
    <h2>Get Person by ID</h2>
    <input type="text" id="personId" placeholder="Enter Person ID" />
    <button onclick="fetchPersonById()">Get Person</button>
    <div id="personInfo"></div>

    <!-- 새로운 사람 추가 -->
    <h2>Add New Person</h2>
    <input type="text" id="newPersonName" placeholder="Enter New Person's Name" />
    <button onclick="addPerson()">Add Person</button>
    <div id="addPersonResult"></div>

    <script>
        // Fetch all people from /people
        function fetchPeople() {
            fetch('/people')
                .then(response => response.json())
                .then(data => {
                    let result = '<ul>';
                    data.forEach(person => {
                        result += `<li>${person.name} (ID: ${person.id})</li>`;
                    });
                    result += '</ul>';
                    document.getElementById('peopleList').innerHTML = result;
                })
                .catch(error => {
                    document.getElementById('peopleList').innerHTML = 'Error fetching people: ' + error;
                });
        }

        // Fetch a specific person by ID from /person/{id}
        function fetchPersonById() {
        	const id = document.getElementById('personId').value;
            const url = '/person/' + id;  // 문자열로 URL 생성
            fetch(url)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Person not found');
                    }
                    return response.json();
                })
                .then(person => {
                    document.getElementById('personInfo').innerHTML = `Name: ${person.name}, ID: ${person.id}`;
                })
                .catch(error => {
                    document.getElementById('personInfo').innerHTML = 'Error fetching person: ' + error;
                });
        }

        // Add a new person via POST to /person
        function addPerson() {
            const name = document.getElementById('newPersonName').value;
            const personData = {
                name: name,
                id: Math.floor(Math.random() * 1000).toString() // 임의의 ID 생성
            };

            fetch('/person', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(personData)
            })
            .then(response => {
                if (response.ok) {
                    document.getElementById('addPersonResult').innerHTML = 'Person added successfully!';
                    fetchPeople(); // 목록을 갱신
                } else {
                    throw new Error('Failed to add person');
                }
            })
            .catch(error => {
                document.getElementById('addPersonResult').innerHTML = 'Error: ' + error;
            });
        }
    </script>
</body>
</html>