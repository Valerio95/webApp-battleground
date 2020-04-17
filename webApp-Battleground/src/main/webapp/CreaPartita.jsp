<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/button.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>CreaPartita</title>
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

		Inserisci i risultati della partita da aggiungere al tracker:

		<form action="CreazionePartita">
			<label for="composizione">Composizione</label><br> 
			<input type="text" id="composizione" name="composizione" value=""><br> 
			<label for="eroe">Eroe scelto</label><br>
			<input type="text" id="eroe" name="eroe" value=""><br>
			<label for="risultato">Risultato</label><br> 
			<input type="text" id="risultato" name="risultato" value=""><br>
			<label for="note">Note</label><br> 
			<input type="text" id="note" name="note" value=""><br> 
			<label for="rating">Rating</label><br> 
			<input type="text" id="rating" name="rating" value=""><br>
			<input type="submit" value="Aggiungi"> 
			<input type="reset">
		</form>


		<% } %>

		<a href="http://localhost:8080/servlet-ortofrutta/Homepage?scelta=1"
			onMouseOver="self.status=document.referrer;return true"> Torna
			indietro</a>


	</div>
</body>
</html>