<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/button.css" rel="stylesheet" type="text/css">
<link href="css/table.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Profilo Utente</title>
</head>
<body class="sfondo">
	<div>
		<% String messaggio = (String) request.getAttribute("messaggio"); 
	if (messaggio != null ){
		%>
		<h1style="color:Tomato;">ERRORE</h1>
		<%=messaggio%>
		<% }
	else {
%>

			<h1>Ecco il tuo Profilo</h1>

			<br>Da qui puoi gestire il tracker delle tue partite aggiungendo le tue prestazioni e visionando le tue statistiche
			nel tempo.<br>


		Seleziona un'opzione:

		<form action="SceltaUtente">
			<br> <input type="submit" class="button" name="scelta" value="1">
			<label for="aggiungi"><B>Aggiungi una nuova partita</B></label>: aggiungi il tracker di una nuova partita che hai giocato <br> 
			<input type="submit" class="button" name="scelta" value="2"> 
			<label for="statistiche"><B>Statistiche</B></label>: qui puoi vedere lo storico aggiornato delle tue partite<br>
		</form>
		
		<% } %>

	</div>
</body>
</html>