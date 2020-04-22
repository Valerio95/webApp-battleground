<%@page import="it.dstech.modelli.Composizione"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
		<% }
	else {
%>
<%List<Composizione> listaComposizioni = (List<Composizione>)request.getAttribute("lista"); %>
		Inserisci il nome della composizione da aggiungere:

		<form action="/CreazionePartita" method="post">
			
			<label for="composizione">Composizione</label><br> 
			<input type="text" name="composizione"><br> 
			<input type="submit" class="button" name="composizione"><br> 
			
		</form>
<table>
	<tr>
	<th>Lista Composizioni</th></tr>
	<tr><td>Composizione</td> 
	
  
	<% for(Composizione c : listaComposizioni){%>
<tr>

    <td><%=c.getNome()%></td> 
	


<% } %>
</table>

		<% } %>

		<form action="/SceltaUtente">
		<input type="submit" name="scelta" value="Torna indietro"> 

		</form>

	</div>
</body>
</html>