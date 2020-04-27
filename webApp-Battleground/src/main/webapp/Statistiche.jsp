<%@page import="java.util.List"%>
<%@page import="it.dstech.modelli.Partita"%>
<%@page import="it.dstech.modelli.Utente"%>
<%@page import="it.dstech.modelli.Eroe"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/Default.css" rel="stylesheet" type="text/css">
<link href="css/text.css" rel="stylesheet" type="text/css">
<link href="css/table.css" rel="stylesheet" type="text/css"><head>

<meta charset="ISO-8859-1">
<title>CreaPartita</title>
</head>
<body >
	<div class="center">
		<% String messaggio = (String) request.getAttribute("messaggio"); 
	if (messaggio != null ){
		%>
		<h1 style="color:Tomato;">ERRORE</h1>
		<%=messaggio%>
		<% }
	else {
%>
<%List<Partita> listaPartite = (List<Partita>)request.getAttribute("listaPartite"); %>
<%List<Eroe> listaEroi = (List<Eroe>)request.getAttribute("listaEroi"); %>
<%Utente utente = (Utente)session.getAttribute("utente"); %>
<%int totVittorie = (int)request.getAttribute("totaleVittorie"); %>
<%int totPartite = (int)request.getAttribute("totalePartite"); %>
<%int topFour = (int)request.getAttribute("topFour"); %>

		Vedi le tue statistiche:
<table>
	
	<tr><td>totPartite</td> 
	<td>%topfour</td> 
	<td>totVittorie</td> 
	<tr><td>ratingIniziale</td>
	<td>ratingFinale</td>
  
	
<tr>

    <td><%=totPartite%></td> 
	<td><%=topFour%></td>
	<td><%=totVittorie%></td> 
	<tr>
	<td><%=utente.getRatingIniziale()%></td> 
    <td><%=utente.getRatingFinale()%></td> 


</table>


<table>
	<tr>
	<th>Lista Partite</th></tr>
	<tr><td>Composizione</td> 
	<td>Eroe Scelto</td> 
	<td>Posizione Finale</td> 
	<td>Note</td>    
	<td>Rating</td> 
  
	<% for(Partita l : listaPartite){%>
<tr>

    <td><%=l.getComposizione()%></td> 
	<td><%=l.getEroeScelto()%></td>
	<td><%=l.getPosizioneFinale()%></td> 
	<td><%=l.getNote()%></td> 
    <td><%=l.getRating()%></td> 

<% } %>
</table>


<form action="" >
<p> <select name="eroe">
         <%for(Eroe c:listaEroi){%>
         <option value="<%=c.getNome()%>" > <%=c.getNome()%>
         <% } %>
        </select></p>
</form>
<table>
	<tr>
	<th>Lista Partite</th></tr>
	<tr><td>Composizione</td> 
	<td>Eroe Scelto</td> 
	<td>Posizione Finale</td> 
	<td>Note</td>    
	<td>Rating</td> 
  
	<% for(Partita l : listaPartite){%>
<tr>

    <td><%=l.getComposizione()%></td> 
	<td><%=l.getEroeScelto()%></td>
	<td><%=l.getPosizioneFinale()%></td> 
	<td><%=l.getNote()%></td> 
    <td><%=l.getRating()%></td> 

<% } %>
</table>


		
			
		
</body>
</html>