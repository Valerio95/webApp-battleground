<%@page import="it.dstech.modelli.Eroe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Rimozione eroe</title>
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

		<%List<Eroe> listaEroi = (List<Eroe>)request.getAttribute("lista");%>

		<form action="RimuoviEroe">
			<label for="eroe">Seleziona l'eroe da rimuovere</label><br>
			<p>
				NomeProdotto : <select name="idProdotto">

					<%for(Eroe p : listaEroi){%>
		<option value=<%=p.getNome()%>>
						<%=p.getNome()%>

						<% } %>
					
				</select>
			</p>
			<input type="submit" value="Rimuovi">
		</form>
		<% } %>
		<a href="http://localhost:8080/servlet-ortofrutta/Homepage?scelta=1"
			onMouseOver="self.status=document.referrer;return true"> Torna
			indietro</a>

	</div>
</body>
</html>