<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link rel="stylesheet" href="admin.css">
<script>
    window.onload = function() {
            const urlParams = new URLSearchParams(window.location.search);
            if (urlParams.get("message") === "failed") {
                alert("Incorrect Credentials");
            }
        }
    </script>
</head>
<body>
	<div class="main-container">
		<div class="login-container">
			<form class="login-form" action="adminServlet" method="post">
    		<h2>Login</h2>
	    		<label for="username">Username:</label>
	    		<input type="text" name="username" required>
	
	    		<label for="password">Password:</label>
	    		<input type="password" name="password" required>
	
	    		<input type="submit" value="Login">
    		</form>
		</div>
	</div>
</body>
</html>