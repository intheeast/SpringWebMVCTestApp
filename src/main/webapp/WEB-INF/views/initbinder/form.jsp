<!DOCTYPE html>
<html>
<head>
    <title>Submit Form</title>
</head>
<body>
    <h2>Submit a Date</h2>

    <!-- 표준 HTML input 태그를 사용하여 공란 입력 필드 렌더링 -->
    <form method="post" action="/initbinder/submitForm">
        <table>
            <tr>
                <td><label for="date">Enter Date (yyyy-MM-dd):</label></td>
                <td><input type="text" id="date" name="date" placeholder="yyyy-MM-dd" /></td>  <!-- 공란 입력 필드 -->
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>