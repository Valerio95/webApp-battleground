<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Sito di Ortofrutta</title>
</head>
<body class="sfondo">
	<div>
		<% String messaggio = (String) request.getAttribute("messaggio"); 
	if (messaggio != null ){
		%>
		<h1>ERRORE</h1>
		<%=messaggio%>
		<% }
	else {
%>


			<h1>Ecco il tuo Profilo</h1>

			<br>Da qui puoi gestire il tracker delle tue partite aggiungendo le tue prestazioni e visionando le tue statistiche
			nel tempo.<br>


		Seleziona un'opzione:

		<form action="Homepage">
			<br> <input type="radio" id="cerca" name="scelta" value="1">
			<label for="libreria"><B>Libreria</B></label>: puoi esaminare la lista dei libri disponibili per l'acquisto
			e quelli che hai già acquistato su questo sito <br> 
			
			<input type="radio" id="prenotati" name="scelta" value="2"> 
			<label for="biblioteca"><B>Biblioteca</B></label>: puoi prendere in prestito dei libri fino ad un massimo di 30 giorni
			 o restituire i libri già letti<br>
		</form>

		<% } %>

	</div>
</body>
</html>