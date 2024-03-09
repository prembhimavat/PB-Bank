<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body, h1, h2, p, ul, li, form {
	margin: 0;
	padding: 0;
}

body {
	font-family: 'Arial', sans-serif;
}

/* Global Styles */
input,select {
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
.signup-form {
	max-width: 400px;
	margin: 0 auto;
	padding: 20px;
	background-color: #ecf0f1;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.signup-form h2 {
	text-align: center;
	margin-bottom: 20px;
}

.signup-form label {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
}

.signup-form input {
	border: 1px solid #ccc;
	border-radius: 3px;
}

.signup-form button {
	background-color: #3498db;
	color: #fff;
	border: none;
	border-radius: 3px;
	cursor: pointer;
}

.signup-form button:hover {
	background-color: #2980b9;
}
</style>
<title>Insert title here</title>
</head>
<body>
<header>
        <h1>PB Bank!</h1>
        <nav>
			<br/>
		 	<ul>
		 		<li><a href="../transactions/transactionview">View All Transactions</a></li>
				<li><a href="../accounts/customeraccountview">View All Accounts</a></li>
				<li><a href="../customers/dashboard">Dashboard</a></li>
				<li><a href="../customers/logout">Logout</a></li>
			</ul>
		</nav>
	</header>
	<br />
	<h2 style="text-align: center;">Send Money</h2>
	<br />
	<section class="signup-form">
		<form method="post" action="../accounts/transactions">
			<div><b style="color: red;">${message}</b></div>
			<input	type="hidden" value="${id}" name="id"> 
			<label>5 Digit Account Pin</label>
			<input type="password"  name="password" required>
			<label for="accountNo">Select account</label> 
			<select	name="accountNo">
				<c:forEach items="${account}" var="account">
					<option value="${account.getId()}">${account.getId()}</option>
				</c:forEach>
			</select> 
			<br /> <br /> 
			<label> Available Balance - <span>&#8377;</span>${balance}</label> <br /> 
			<input 	type="hidden" value="${balance}" name="balance"> 
			<label>Amount:</label>
			<input type="number" name="amount" required>

			<button type="submit" value="submit">Submit</button>

		</form>
	</section>
		  <footer>
        <p>&copy; 2024 PB Bank. All rights reserved.</p>
    </footer>
</body>
</html>