<%@page import="it.dstech.modelli.Utente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/buttons.css" rel="stylesheet" type="text/css">
<link href="css/background.css" rel="stylesheet" type="text/css">
<link href="css/text.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Battleground Tracker</title>
</head>

	<body class="sfondo">
	<div class="center" >
	
	<% String messaggio = (String) request.getAttribute("messaggio"); 
		if (messaggio != null ){  %>
			<h1 style="color:Tomato;"><%=messaggio%></h1>
		
		<% } %>


			

				<h1>Benvenuto in BattleGround Tracker!</h1>

				<i>Da qui puoi effettuare il tracking delle tue partite di Battleground e tenere nota dei tuoi successi.</i>
				
				<br><h3>Effettua l'accesso o registrati se ancora non hai un account utente:</h3>


				<form action= "Accesso" method="post">

					<label for="username">Username:</label><br>
		  			<input type="text" name="username" placeholder="E-mail"><br>
		  			<label for="password">Password:</label><br>
		  			<input type="password" name="password" placeholder="Password">
		  			<br>
					<br> <input type="submit" class="buttons" name="scelta" value="Log In" />
					<br>
					<br>Non sei ancora registrato? <br>
					<br>
					<input type="submit" class="buttons" name="scelta" value="Sign In" />
				</form>

			</div>
		</body>
</html>