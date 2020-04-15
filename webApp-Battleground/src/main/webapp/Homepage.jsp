<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Battleground Tracker</title>
</head>

	<body class="sfondo">
	
	<% String messaggio = (String) request.getAttribute("messaggio"); 
		if (messaggio != null ){  %>
			<h1><%=messaggio%></h1>
		
		<% } else { %>

			<CENTER>
				<h1>Benvenuto in LibriOnline!</h1>

				<i>Da qui puoi comprare i tuoi libri preferiti nella nostra sezione </i><b>Libreria</b><i> o prenderli in prestito
				fino a un massimo di 30 giorni nella sezione </i><b>Biblioteca</b><i>.</i>
				
				<br><h3>Effettua l'accesso:</h3>

				<form action= "gestioneAccesso" >
					<label for="username">Username:</label><br>
		  			<input type="text" name="username" placeholder="E-mail"><br>
		  			<label for="password">Password:</label><br>
		  			<input type="password" name="password" placeholder="Password">
		  			<br>
					<br> <input type="submit" class="button" name="scelta" value="Log In" />
					<br>
					<br>Non sei ancora registrato? <br>
					<br>
					<input type="submit" class="button" name="scelta" value="Sign In" />
				</form>
		 <% } %>
			</CENTER>
		</body>
</html>