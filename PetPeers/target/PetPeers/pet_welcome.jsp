<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<style type="text/css">
li {
	list-style-type: none;
	float: left;
}

a {
	text-decoration: none;
	margin: 3px;
	border-width: 2px;
	background-color: #87ceeb;
	color: white;
	padding: 13px;
	border-radius: 5px;
}

.logoffclass {
	border-width: 1px;
	background-color: #87ceeb;
	color: white;
	padding-top: 5px;
	padding-bottom: 5px;
	border-radius: 7px;
}

ol {
	position: absolute;
	margin-top: 30px;
	margin-left: 500px;
}
</style>
</head>
<body>
	<div>
		<center>
			<font style="color: green;">
				<center>
					<h3 style='color: green;'>Welcome ${sessionScope.userName}</h3>
				</center>
				<form action="./login" method="get">
					<input type="submit" value="LogOff" class="logoffclass">
				</form>
			</font> <span style="color: black;" class="heading"><font size="5">What
					Do you want to Do?</font></span>
		</center>
		<ol>
			<li><a href="./pet_form.jsp">Add Pet</a></li>
			<li><a href="./pets">Buy a Pet</a></li>
			<li><a href="./pet_search.jsp">Search Pets</a></li>
		</ol>
	</div>

</body>
</html>