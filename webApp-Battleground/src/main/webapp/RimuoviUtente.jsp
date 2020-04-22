<%@page import="it.dstech.modelli.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/Default.css" rel="stylesheet" type="text/css">
<link href="css/text.css" rel="stylesheet" type="text/css">
<link href="css/table.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="center">
		<% String messaggio = (String) request.getAttribute("messaggio"); 
	if (messaggio != null ){
		%>
		<h1 style="color:Tomato;">ERRORE</h1>
		<%=messaggio%>
		
		<form action="/Homepage.jsp">
		<input type="submit" class="button" name="scelta" value="Torna alla home"> 
		
		</form>
		<% }
	else {
%>
<% Utente utente = (Utente)session.getAttribute("utente"); %>
<div>
<img alt="immagine" src="data:image/jpg;base64,<%= session.getAttribute("immagineString") %>"> <br>
</div>

			<h1>Vuoi veramente rimuovere il tuo profilo?</h1>

			

		<form action="RimuoviUtente" >
		
			<input type="submit" class="button" name="scelta" value="Si"> 
			<input type="submit" class="button" name="scelta" value="No"> 
			
			
		</form>
		
		<% } %>

	</div>
</body>
</html>