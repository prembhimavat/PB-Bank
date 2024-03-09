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
.transaction-history {
    background-color: #ecf0f1;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
.transaction-history h2 {
    color: #3498db;
}

.transaction-history table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

.transaction-history th,
.transaction-history td {
    border: 1px solid #ddd;
    padding: 10px;
    text-align: left;
}

.transaction-history th {
    background-color: #3498db;
    color: #fff;
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
				<li><a href="../accounts/addaccountview">Create new Account</a></li>
				<li><a href="../customers/dashboard">Dashboard</a></li>
				<li><a href="../customers/logout">Logout</a></li>
			</ul>
		</nav>
	</header>
	<div class="transaction-history">
	<table>
		<tr>
			<th>AccountId</th>
			<th>Account Type</th>
			<th>Account Balance</th>
			<th>Update</th>
			<!-- <th>Delete</th> -->
			<th>Send Money</th>
		</tr>

		<c:forEach items="${account}" var="account">
			<tr>
				<td>${account.getId()}</td>
				<td>${account.getAccountType()}</td>
				<td><span>&#8377;</span>${account.getBalance()}</td>
				<td><a href="../accounts/updateaccount?id=${account.getId()}">Update</a></td>
				<%-- <td><a href="../accounts/delete?id=${account.getId()}">Delete</a></td> --%>
				<td><a href="../accounts/sendmoney?id=${account.getId()}">Send Money</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	  <footer>
        <p>&copy; 2024 PB Bank. All rights reserved.</p>
    </footer>
</body>
</html>