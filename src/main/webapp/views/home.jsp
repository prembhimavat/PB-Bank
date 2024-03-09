<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body {
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
}

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

a {
    text-decoration: none;
    color: #fff;
    font-weight: bold;
}

.hero {
    background-color: #ecf0f1;
    text-align: center;
    padding: 2em;
}

.btn {
    display: inline-block;
    background-color: #3498db;
    color: #fff;
    padding: 10px 20px;
    margin-top: 10px;
    text-decoration: none;
    border-radius: 5px;
}

.features {
    display: flex;
    justify-content: space-around;
    padding: 2em;
}

.feature {
    text-align: center;
}

footer {
    background-color: #2c3e50;
    color: #fff;
    text-align: center;
    padding: 1em;
    position: fixed;
    width: 100%;
    bottom: 0;
}

</style>
<title>Landing page</title>
</head>
<body>
  <header>
        <h1>PB Bank!</h1>
        <nav>
            <ul>
    			<li><a href="../views/signUp.jsp">Sign Up</a></li>
				<li><a href="../views/login.jsp">Login</a></li>
            </ul>
        </nav>
    </header>

    <section class="hero">
        <h2>Welcome to PB Bank</h2>
        <p>Experience modern banking with us.</p>
        <a href="../views/signUp.jsp" class="btn">Get Started</a>
    </section>

    <section class="features">
        <div class="feature">
            <h3>Online Banking</h3>
            <p>Manage your accounts from anywhere, anytime with our secure online banking services.</p>
        </div>
        <div class="feature">
            <h3>Mobile App</h3>
            <p>Download our mobile app for convenient and on-the-go banking.</p>
        </div>
        <div class="feature">
            <h3>Security</h3>
            <p>Your financial security is our top priority. We use advanced encryption to protect your data.</p>
        </div>
    </section>

    <footer>
        <p>&copy; 2024 PB Bank Name. All rights reserved.</p>
    </footer>
</body>
</html>