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
	<div align="center">
		<form action="accountDetails" method="post">
			<table>
				<tr>
					<td>Account Number</td>
					<td><input type="text" name="accountNo"></td>
					<td><input type="submit" value="Click"></td>
					<td><a href="index">||Home||</a></td>
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
				<td>AccountNo</td>
				<td>PinNumber</td>
				<td>Account Type</td>
				<td>Account Status</td>
				<td>Account Balance</td>
			</tr>
			<tr>
				<td>${account.accountNo}</td>
				<td>${account.pinNumber}</td>
				<td>${account.accountType}</td>
				<td>${account.accountStatus}</td>
				<td>${account.accountBalance}</td>
			</tr>
		</table>
	</div>
</body>
</html>