<%@page import="it.dstech.modelli.Utente"%>
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

			<div class="center">
				<h1>Benvenuto in BattleGround Tracker!</h1>

				<i>Da qui puoi effettuare il tracking delle tue partite di Battleground e tenere nota dei tuoi successi.</i>
				
				<br><h3>Effettua l'accesso o registrati se ancora non hai un account utente:</h3>

				<form action= "" method="post">
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
		 <hr><ol> <%
            List<Utente> lista = (List<Utente>)request.getAttribute("lista");
            for (Utente persona : lista) { %>
                <li> <%= persona.getUsername()%>  <%= persona.getPassword()%></li> <%
            } %>
        </ol><hr>
			</div>
		</body>
</html>