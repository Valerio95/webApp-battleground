<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/Default.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>CreaPartita</title>
</head>
<body class="sfondo">
	<div>
		<% String messaggio = (String) request.getAttribute("messaggio"); 
	if (messaggio != null ){
		%>
		<h1 style="color:Tomato;">ERRORE</h1>
		<%=messaggio%>
		<% }
	else {
%>

		Inserisci i risultati della partita da aggiungere al tracker:

		<form action="CreazionePartita">
			<label for="composizione">Composizione</label><br> 
			<input type="text"  name="composizione"><br> 
			<label for="eroe">Eroe scelto</label><br>
			<input type="text"  name="eroe"><br>
			<label for="risultato">Posizione finale</label><br> 
			<input type="number" name="PosizioneFinale"><br>
			<label for="note">Note</label><br> 
			<input type="text" name="note"><br> 
			<label for="rating">Rating</label><br> 
			<input type="number" name="rating" ><br>
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