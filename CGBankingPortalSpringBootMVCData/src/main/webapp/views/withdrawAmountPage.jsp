<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<div align="center">Deposit Amount</div>
	<form action="withdrawAmount12" method="post">
		<table>
			<tr>
				<td>Enter Account Number</td>
				<td><input type="text" name="accountNo"></td>
			</tr>
			<tr>
				<td>Enter Deposit Balance</td>
				<td><input type="text" name="withdarwBalance" required></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	</div>
	<div align="center" class="error">${errorMessage}</div>
	<br>
	<br>
	<div align="center">
		<table>
			<tr>
				<td>New Account Balance</td>
			</tr>
			<tr>
				<td>${accountBalance}</td>
			</tr>
		</table>
	</div>
</body>
</html>