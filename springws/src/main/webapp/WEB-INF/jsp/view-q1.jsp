<!DOCTYPE html>
<html>
<head>
    <title>Question 1</title>
</head>
<body>
    <h2>Question 1: Add the numbers</h2>
    <form action="/q1" method="post">
        Number 1: <input type="text" name="number1" /><br/>
        Number 2: <input type="text" name="number2" /><br/>
        Result: <input type="text" name="result" /><br/>
        <input type="submit" name="submit" value="Submit" />
    </form>
    <div>${message}</div>
</body>
</html>
