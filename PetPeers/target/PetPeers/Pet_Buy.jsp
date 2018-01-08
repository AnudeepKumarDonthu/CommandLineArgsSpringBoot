<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buy Pet</title>
<style type="text/css">
.formclass {
	text-align: left;
}

.inputclass {
	border: 0px;
}

.bclass {
	border-width: 2px;
	color: white;
	padding-left: 20px;
	padding-right: 20px;
	padding-top: 13px;
	padding-bottom: 13px;
	background-color: #87ceeb;
	border-radius: 10px;
}

.dclass a {
	text-decoration: none;
	margin: 3px;
	border-width: 2px;
	color: #87ceeb;
	padding: 13px;
}

.dclass a:HOVER {
	color: white;
	background-color: #87ceeb;
	border-radius: 10px;
}

.dclass .hclass {
	text-decoration: none;
	border-width: 2px;
	color: white;
	background-color: #87ceeb;
	border-radius: 10px;
	padding: 13px;
}

.sclass {
	margin-left: 225px;
	float: left;
}

.dclass {
	position: relative;
	margin-left: 930px;
}

fieldset {
	position: absolute;
	margin-left: 225px;
	margin-top: 30px;
	bordercolor: lightblue;
	width: 870px;
	border: 1;
}
</style>
</head>
<body>
	<a href="./pet_welcome.jsp"><span class="sclass"><font color="#917567" size="6">Pet
			Peers</font></span></a>
	<div class="dclass">
		<a href="./pets" class="hclass" class="hclass"><font size="5">Home</font></a>
		<a href="pet_form.jsp"><font size="5">Add Pet</font></a>
	</div>
	<fieldset>
		<legend>Buy Pet</legend>
		<table border="0" width="100%" class="formclass">
			<form action="./buypet" method="post">
				<tr>
					<th>User Id</th>
					<th>:</th>
					<td><input type="text" value="${sessionScope.userID}"
						name="cid" readonly class="inputclass" /></td>
				</tr>
				<tr>
					<th>Pet Id</th>
					<th>:</th>
					<td><input type="text" value="${petList.id }" name="pid"
						readonly class="inputclass" /></td>
				</tr>
				<tr>
					<th>Pet Type</th>
					<th>:</th>
					<td><input type="text" value="${petList.petType }"
						name="pettype" readonly class="inputclass" /></td>
				</tr>
				<tr>
					<th>Pet Name</th>
					<th>:</th>
					<td><input type="text" value="${petList.name }" name="petname"
						readonly class="inputclass" /></td>
				</tr>
				<tr>
					<th>Quantity</th>
					<th>:</th>
					<td><input type="number" name="qty" placeholder="Quantity"
						value="1" readonly class="inputclass" /></td>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<td class="buttonclass"><input type="submit" class="bclass"
						value="Place Order" /></td>
				</tr>
			</form>
		</table>
	</fieldset>
</body>
</html>