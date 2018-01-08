<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dispaly" uri="http://displaytag.sf.net"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"%>
<!DOCTYPE html>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>Pet Peers</title>
<meta charset="utf-8" />
<style type="text/css">
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

.odd {
	background-color: #9FBF8C;
}

.even {
	background-color: #C8AB65;
}

th {
	background-color: threedhighlight;
	width: 400px;
}

td {
	text-align: center;
}

.sclass {
	margin-left: 225px;
	float: left;
}

.dclass {
	position: relative;
	margin-left: 930px;
}

.distableclass {
	margin-top: 20px;
}

a:HOVER {
	text-decoration: none;
}

.buydivclass {
	position: absolute;
	margin-left: 1100px;
	margin-top: 90px;
}

.dispclass {
	margin-left: 200px;
	float: left;
}

.buydivclass table tr td a {
	text-decoration: none;
	border-width: 2px;
	background-color: #87ceeb;
	color: white;
	padding: 4px;
	border-radius: 3px;
}

.buydivclass table tr td {
	padding: 7px;
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
	<div class="dispclass">
		<table align="center" border="1" bordercolor="lightblue" width="900px"
			cellpadding="1" cellspacing="0" width="900px" align="center"
			border="0" class="distableclass">
			<tr>
				<th align="left" style="background-color: lightblue;">Pet
					Information</th>
			</tr>
			<tr>
				<td><dispaly:table name="petResult" cellspacing="0"
						cellpadding="10" requestURI="./pets" pagesize="10" export="true">
						<dispaly:column property="id" title="#" sortable="true"></dispaly:column>
						<dispaly:column property="name" title="Pet Name" sortable="true"></dispaly:column>
						<dispaly:column property="avlQty" title="Quantity Avl"
							sortable="true"></dispaly:column>
						<dispaly:column property="place" title="Place" sortable="true"></dispaly:column>
						<dispaly:column property="age" title="Age" sortable="true"></dispaly:column>
						<dispaly:column property="petType" title="Pet Type"
							sortable="true"></dispaly:column>
						<dispaly:setProperty name="paging.banner.placement" value="bottom"></dispaly:setProperty>
					</dispaly:table></td>
			</tr>
		</table>
	</div>
	<div class="buydivclass">
		<c:forEach var="petDetails" items="${petResult}" varStatus="counter">
			<table>
				<tr>
					<td><a href="searchPets?id=${petDetails.id}"><font
							size="4">Buy</font></a></td>
				</tr>
			</table>
		</c:forEach>
	</div>
</body>
</html>
