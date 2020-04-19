<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/Default.css" rel="stylesheet" type="text/css">
<link href="css/text.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Registrazione</title>
</head>

			<div class="center" >
	
	<% String messaggio = (String) request.getAttribute("messaggio"); 
		if (messaggio != null ){  %>
			<h1 style="color:Tomato;"><%=messaggio%></h1>
		
		<% } %>

				<h1>Effettua la registrazione</h1>
				
				<h3>Inserisci le tue credenziali:</h3>


				<form action= "Registrati" method="post">

					<b><label for="username">Username:</label><br></b>
		  			<input2><input type="text" name="username" placeholder="E-mail"></input2><br>
		  			<br>
		  			<b><label for="password">Password:</label><br></b>
		  			<input2><input type="password" name="password" placeholder="Password"></input2><br>
		  			<br>
		  			<b><label for="password">Immagine:</label><br></b>
		  			<input type="file" name="image" >
		  			<br>
					<br><button><input type="submit" class="button" name="scelta" value="Sign In" /></button>
				</form>

			</div>
</html>