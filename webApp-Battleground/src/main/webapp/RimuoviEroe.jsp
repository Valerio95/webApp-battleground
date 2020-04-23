<%@page import="it.dstech.modelli.Eroe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/Default.css" rel="stylesheet" type="text/css">
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

		<%List<Eroe> listaEroi = (List<Eroe>)session.getAttribute("lista");%>
<table class="table">
<tr>
  <th>Lista Eroi</th>
</tr>
<tr>
    <td>
Nome
</td> 
<td>
Potere</td> 
<td>
Costo</td> 
<td>
HP</td>    

  
<% for(Eroe l : listaEroi){%>

<tr>

    <td>
<%=l.getNome()%> 
</td> 
<td>
<%=l.getPotere()%>
</td>
<td>
<%=l.getCosto()%>
</td> 
<td>
<%=l.getHP()%>
</td> 
<td>
<form action="RimuoviEroe">
<input type="submit" value="Rimuovi">
</form></td> 
<% } %>
</table>
		
		<% } %>
		<form action="SceltaAdmin">
		<input type="submit" name="azione" value="Torna indietro">
		
		</form>
	</div>
</body>
</html>