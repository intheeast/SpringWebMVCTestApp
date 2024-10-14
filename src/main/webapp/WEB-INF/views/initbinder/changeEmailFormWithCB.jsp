<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Change Email</title>
</head>
<body>
    <h2>Change Your Email Address</h2>

    <form method="post" action="/initbinder/changeEmailWithConstructorBinding">
        <table>
            <tr>
                <td><label for="oldEmailAddress">Old Email Address:</label></td>
                <td><input type="text" id="oldEmailAddress" name="oldEmailAddress" /></td>
            </tr>
            <tr>
                <td><label for="newEmailAddress">New Email Address:</label></td>
                <td><input type="text" id="newEmailAddress" name="newEmailAddress" /></td>
            </tr>
            <tr>
                <td><label for="unauthorizedField">Unauthorized Field:</label></td>
                <td><input type="text" id="unauthorizedField" name="unauthorizedField" /></td>  <!-- 허용되지 않은 필드 -->
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Change Email" />
                </td>
            </tr>
        </table>
    </form>

</body>
</html>