<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/button.css" rel="stylesheet" type="text/css">
<link href="css/table.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="sfondo">
	
	<% String messaggio = (String) request.getAttribute("messaggio"); 
		if (messaggio != null ){  %>
			<h1><%=messaggio%></h1>
		
		<% } %>


			<div class="center" >

				<h1>Effettua laregistrazione</h1>
				
				<br><h3>Inserisci le tue credenziali:</h3>


				<form action= "Registrati" method="post">

					<label for="username">Username:</label><br>
		  			<input type="text" name="username" placeholder="E-mail"><br>
		  			<label for="password">Password:</label><br>
		  			<input type="password" name="password" placeholder="Password"><br>
		  			<input type="file" name="image" placeholder="Inserisci l'immagine del profilo">
		  			
					<input type="submit" class="button" name="scelta" value="Sign In" />
				</form>

			</div>

</body>
</html>