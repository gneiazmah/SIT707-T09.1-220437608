<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="/login" method="post">
        Username: <input type="text" name="username" /><br/>
        Password: <input type="password" name="passwd" /><br/>
        Date of Birth: <input type="text" name="dob" /><br/>
        <input type="submit" value="Login" />
    </form>
    <div class="error-message">${message}</div>
</body>
</html>
