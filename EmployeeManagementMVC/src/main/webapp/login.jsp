<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title> 
<link rel="stylesheet" type="text/css" href="css/LoginCSS.css">

</head>
<body>

<div class="imageSlider">
    <div class="loginbox">
        <img src="image/UserLogin.png" class="User">
        <h1>Login Here</h1>
        <form action="<%=request.getContextPath()%>/login" method="post">
            <p>Username</p>
            <input type="text" name="username" placeholder="Username">
            <p>Password</p>
            <input type="password" name="password" placeholder="Password">
            <input type="submit" name="submit" value="Submit">
        </form>
        
    </div>

    </div>
</body>
</html>