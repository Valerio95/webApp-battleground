<%@page import="it.dstech.modelli.Utente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/Default.css" rel="stylesheet" type="text/css">
<link href="css/text.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Battleground Tracker</title>
</head>

	<body class="sfondo">
	<div class="center" >
	
	<% String messaggio = (String) request.getAttribute("messaggio"); 
		if (messaggio != null ){  %>
			<h1 style="color:red;"><%=messaggio%></h1>
		
		<% } %>

				<h1>Benvenuto in BattleGround Tracker!</h1>

				<i>Da qui puoi effettuare il tracking delle tue partite di Battleground e tenere nota dei tuoi successi.</i>
				
				<br><h3>Effettua l'accesso o registrati se ancora non hai un account utente:</h3>


				<form action= "Accesso" method="post">

					<label for="username">Username:</label><br>
		  			<input2><input type="text" name="username" placeholder="E-mail"></input2><br>
		  			<label for="password">Password:</label><br>
		  			<input2><input type="password" name="password" placeholder="Password"></input2>
		  			<br>
		  			<br>
					<button> <input type="submit" name="scelta" value="Log In" /></button>
					<br>
					<br>Non sei ancora registrato? <br>
					<br>
					<button><input type="submit" name="scelta" value="Sign In" /></button>
					
				</form>

			</div>
		</body>
</html>