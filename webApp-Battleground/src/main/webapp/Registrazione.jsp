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


				<form action= "Registrazione" method="post" enctype="multipart/form-data">

					<b><label for="username">Username:</label><br></b>
		  			<input type="text" class="button" name="username" placeholder="E-mail"><br>
		  			<br>
		  			<b><label for="password">Password:</label><br></b>
		  			<input type="password" class="button" name="password" placeholder="Password"><br>
		  			<br>
		  			<b><label for="rating">Rating:</label><br></b>
		  			<input type="number" class="button" name="rating" placeholder="Rating"><br>
		  			<br>
		  			<b><label for="immagine">Immagine:</label><br></b>
		  			<input type="file" class="button" name="image" placeholder="Inserisci l'immagine del porfilo">
		  			<br>
					<br><input type="submit" class="button" name="scelta" value="Sign In" />
				</form>

			</div>
</html>