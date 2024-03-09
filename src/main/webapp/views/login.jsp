<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up</title>
<style>
<style>
/* styles.css */

/* General Reset */
body, h1, h2, p, ul, li, form {
    margin: 0;
    padding: 0;
}

body {
    font-family: 'Arial', sans-serif;
}

/* Global Styles */
input {
    width: 100%;
    padding: 10px;
    margin: 10px 0;
    box-sizing: border-box;
}

button {
    padding: 10px 15px;
    background-color: #3498db;
    color: #fff;
    border: none;
    cursor: pointer;
}

/* Specific Styles */
header {
    background-color: #3498db;
    color: #fff;
    padding: 1em;
    text-align: center;
}

nav ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
}

nav li {
    display: inline;
    margin-right: 20px;
}

nav a {
    text-decoration: none;
    color: #fff;
    font-weight: bold;
}

.hero {
    text-align: center;
    padding: 50px;
    background-color: #ecf0f1;
}

footer {
    background-color: #34495e;
    color: #fff;
    text-align: center;
    padding: 1em;
    position: fixed;
    bottom: 0;
    width: 100%;
}

/* Sign Up Page Specific Styles */
.login-form {
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    background-color: #ecf0f1;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.login-form h2 {
    text-align: center;
    margin-bottom: 20px;
}

.login-form label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
}

.login-form input {
    border: 1px solid #ccc;
    border-radius: 3px;
}

.login-form button {
    background-color: #3498db;
    color: #fff;
    border: none;
    border-radius: 3px;
    cursor: pointer;
}

.login-form button:hover {
    background-color: #2980b9;
}

</style>
</head>
<body>
	<header>
        <h1>PB Bank!</h1>
   	<nav>
		<ul>
			<li><a href="../views/signUp.jsp">Sign Up</a></li>
			<li><a href="../views/login.jsp">Login</a></li>
			<li><a href="../views/home.jsp">Home</a></li>
		</ul>
	</nav>
	</header>
	<h2 style="text-align: center;">Welcome back!</h2>
<section class="login-form">
	<form method="post" action="../customers/login">
		<div><b style="color: red;">${message}</b></div><br/> 
		<label>Enter Id</label> <input type="text" name="id" required>
		<label>Enter Password</label> <input type="password" name="password" required>
		<input type="submit" value="Submit">
	</form>
</section>
    <footer>
        <p>&copy; 2024 PB Bank. All rights reserved.</p>
    </footer>
</body>
</html>