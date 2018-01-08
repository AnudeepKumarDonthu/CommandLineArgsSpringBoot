<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Pet</title>
<style type="text/css">
a {
	text-decoration: none;
	margin: 3px;
	border-width: 2px;
	color: #87ceeb;
	padding: 13px;
}

a:HOVER {
	color: white;
	background-color: #87ceeb;
	border-radius: 10px;
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

.hclass {
	text-decoration: none;
	border-width: 2px;
	color: white;
	background-color: #87ceeb;
	border-radius: 10px;
	padding: 13px;
}

.ageclass {
	width: 170px;
}

.formclass {
	text-align: left;
	margin-top: 10px;
}

.buttonclass {
	text-align: center;
}
spam a:HOVER {
	background-color: white;
	color: #87ceeb;
}
</style>
</head>
<body>
	<table align="center" border="0">
		<tr valign="top">
			<td align="left"><spam><a href="./pet_welcome.jsp"><font
					color="#917567" size="6">Pet Peers</font></a></spam></td>
			<td align="right"><a href="./pets" /><font size="5">Home</font></a><a
				href="pet_form.jsp" class="hclass"><font size="5">Add Pet</font></a></td>
		</tr>
		<td colspan="2">
			<table border="1" bordercolor="lightblue" cellpadding="1" width="800"
				cellspacing="0" class="formclass">
				<tr>
					<td>
						<form action="./searchPets" method="post" name="fname" id="formid">
							<table cellspacing="30">
								<tr>
									<th>Pet Type<font color="red">*</font></th>
									<td><select name="pettype" required="required">
											<option value="dog">Dog</option>
											<option value="rabbit">Rabbit</option>
											<option value="cat">Cat</option>
											<option value="snake">Snake</option>
									</select></td>
								</tr>
								<tr>
									<th>Size<font color="red">*</font></th>
									<td><input type="radio" name="petsize" value="large"
										checked="checked">Large <input type="radio"
										name="petsize" value="medium">Medium <input
										type="radio" name="petsize" value="small">Small</td>
								</tr>
								<tr>
									<th>Name<font color="red">*</font></th>
									<td><input type="text" name="name" placeholder="Name"
										autofocus="autofocus" required /></td>
								</tr>
								<tr>
									<th>Age<font color="red">*</font></th>
									<td><input type="number" name="age" placeholder="Age"
										max="99" min="1" class="ageclass" required /></td>
								</tr>
								<tr>
									<th>Place<font color="red">*</font></th>
									<td><input type="text" name="place" placeholder="Place"
										maxlength="50" required /></td>
								</tr>
								<tr>
									<th></th>
									<td><input type="submit" value="Search" class="bclass"></td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
			</table>
		</td>
		</tr>
</body>
</html>