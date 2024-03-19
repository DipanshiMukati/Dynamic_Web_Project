<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<!-- <form action="Welcome.jsp"> -->
	<!-- <form action="FirstServlet" method="post"> -->
	<form action="UserRegistrationCtl " method="post">
		<center>
			<table>
				<tr>

					<th>FirstName</th>
					<td><input type="text" name="firstName" /></td>


				</tr>

				<tr>

					<th>lastName</th>
					<td><input type="text" name="lastName" /></td>


				</tr>

				<tr>

					<th>LoginID</th>
					<td><input type="text" name="lognId" /></td>


				</tr>

				<tr>

					<th>DOB</th>
					<td><input type="Date" name="dob" /></td>


				</tr>


				<tr>

					<th>Password</th>
					<td><input type="password" name="password" /></td>


				</tr>

				<tr>

					<th>Address</th>
					<td><input type="text" name="address" /></td>


				</tr>

				<tr>

					<th></th>
					<td><input type="submit"></td>


				</tr>



			</table>

		</center>
	</form>


</body>
</html>