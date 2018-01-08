<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In</title>
<script type="text/javascript">
	function validateForm() {
		var formobj = document.forms['regform'];
		if (formobj['password'].value != formobj['repassword'].value) {
			document.getElementById("rpspan").innerHTML = "*Password doesn't Match*";
			return false;
		}
		return true;
	}
</script>
<style type="text/css">
.bclass {
	border-width: 2px;
	color: white;
	padding-left: 10px;
	padding-right: 1 0px;
	padding-top: 7px;
	padding-bottom: 7px;
	background-color: #87ceeb;
	border-radius: 10px;
}

.logindiv {
	margin-left: 320px;
	float: left;
}

.registrationdiv {
	position: absolute;
	margin-left: 620px;
}

.registrationdiv {
	border: 2px;
	border-style: solid;
	border-color: red;
	padding: 15px;
}

.logindiv {
	border: 2px;
	border-style: solid;
	border-color: red;
	padding: 15px;
	padding-bottom: 31.5px;
}

table {
	text-align: left;
}

.heading {
	margin-left: 480px
}

.outerdiv {
	padding-top: 10px;
}

#guestid {
	margin-left: 50px;
}	 
</style>
</head>
<body>
	<span class="heading"><font style="color: aqua;" size="7">Welcome
			to Pet Home</font></span>
	<div class="outerdiv">
		<div class="logindiv">
			<span><font style="color: green; padding-left: 100px;"
				size="5">Yes</font></span>
			<form action="./login" method="post">
				<table>
					<tr>
						<th>User Name</th>
						<th>:</th>
						<td><input type="text" name="username" placeholder="UserName"
							autofocus="autofocus" required /></td>
					</tr>
					<tr>
						<th>Password</th>
						<th>:</th>
						<td><input type="password" size="20" name="password"
							placeholder="Password" required /></td>
					</tr>
					<tr>
						<th></th>
						<td></td>
						<td class="ltr"><input type="submit" name="login"
							value="Sign In" class="bclass"></td>
					</tr>
				</table>
			</form>
			<form action="./buypet" method="get" id="guestformid">
				<input type="submit" name="gustuser" value="Continue As Guest"
					class="bclass" id="guestid">
			</form>
		</div>
		<div class="registrationdiv">
			<span><font style="color: green; padding-left: 50px;" size="5">No.
					I would Like to Sign Up for a Account</font></span>
			<form action="./login" method="post" name="regform"
				onsubmit="return validateForm()">
				<table>
					<tr>
						<th>User Name</th>
						<th>:</th>
						<td><input type="text" name="username" placeholder="UserName"
							autofocus="autofocus" maxlength="50" required /></td>
					</tr>
					<tr>
						<th>Password</th>
						<th>:</th>
						<td><input type="password" size="20" name="password"
							placeholder="Password" maxlength="50" required /></td>
					</tr>
					<tr>
						<th>Password(Repeat)</th>
						<th>:</th>
						<td><input type="password" size="20" name="repassword"
							placeholder="Password" maxlength="50" required /><span
							id="rpspan" style="color: red;"></span></td>
					</tr>
					<tr>
						<th>Name</th>
						<th>:</th>
						<td><input type="text" size="20" name="name"
							placeholder="Name" maxlength="50" required /></td>
					</tr>
					<tr>
						<th></th>
						<td></td>
						<td class="ltr"><input type="submit" name="login"
							value="Create New Account" class="bclass"></td>
					</tr>
				</table>

			</form>

		</div>
	</div>
</body>
</html>