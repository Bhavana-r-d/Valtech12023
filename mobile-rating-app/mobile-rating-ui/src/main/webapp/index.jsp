<!DOCTYPE html>
<html>
<head>
<title>Fancy Phone Number Ranker</title>
<style>
body {
	font-family: 'Arial', sans-serif;
	background-color: #f8f8f8;
	margin: 0;
	padding: 0;
	text-align: center;
}

h1 {
	color: #333;
}

form {
	max-width: 400px;
	margin: 20px auto;
	background: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

p {
	color: #555;
}

textarea {
	width: calc(100% - 12px);
	padding: 8px;
	box-sizing: border-box;
	margin-top: 4px;
	margin-bottom: 10px;
}

input[type="submit"] {
	background-color: #4caf50;
	color: white;
	padding: 10px 15px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<h1>Fancy Phone Number Ranker</h1>
	<form action="MobileRankingServlet" method="post">
		<p>Enter ten 10-digit phone numbers, one per line:</p>
		<textarea name="phoneNumbers" rows="10" cols="30"></textarea>
		<br> <input type="submit" value="Rank Numbers">
	</form>
</body>
</html>