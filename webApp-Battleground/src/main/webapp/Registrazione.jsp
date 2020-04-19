<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/buttons.css" rel="stylesheet" type="text/css">
<link href="css/table.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Registrazione</title>
</head>

<body class="sfondo">
			<div class="center" >
	
	<% String messaggio = (String) request.getAttribute("messaggio"); 
		if (messaggio != null ){  %>
			<h1 style="color:Tomato;"><%=messaggio%></h1>
		
		<% } %>




				<h1>Effettua la registrazione</h1>
				
				<h3>Inserisci le tue credenziali:</h3>


				<form action= "Registrati" method="post">

					<label for="username">Username:</label><br>
		  			<input type="text" name="username" placeholder="E-mail"><br>
		  			<br>
		  			<label for="password">Password:</label><br>
		  			<input type="password" name="password" placeholder="Password"><br>
		  			<br>
		  			<label for="password">Immagine:</label><br>
		  			<input type="file" name="image" >
		  			<br>
					<br><input type="submit" class="button" name="scelta" value="Sign In" />
				</form>

			</div>

</body>
</html>