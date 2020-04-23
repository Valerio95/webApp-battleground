<%@page import="java.util.List"%>
<%@page import="it.dstech.modelli.Partita"%>
<%@page import="it.dstech.modelli.Composizione"%>
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
<%List<Partita> listaPartite = (List<Partita>)request.getAttribute("listaPartite"); %>
<%List<Composizione> listaComposizioni = (List<Composizione>)request.getAttribute("listaComposizioni"); %>
<%List<Eroe> listaEroi = (List<Eroe>)request.getAttribute("listaEroi"); %>
		Inserisci i risultati della partita da aggiungere al tracker:

		<form action="/CreazionePartita" method="post">
			<label for="composizione">Composizione</label><br> 
			<p>Composizione: <select name="composizione">
         <%for(Composizione c:listaComposizioni){%>
         <option value=<%=c%> > <%=c%>
         <% } %>
        </select></p>
			 
			<label for="eroe">Eroe scelto</label><br>
			<p>Eroe scelto: <select name="eroe">
         <%for(Eroe e: listaEroi){%>
         <option value=<%=e.getNome()%> > <%=e.getNome()%>
         <% } %>
        </select></p>
			<label for="risultato">Posizione finale</label><br> 
			<p>Posizione Finale: <select name="PosizioneFinale">
         <%for(int i=0;i<=8;i++){%>
         <option value=<%=i%> > <%=i%>
         <% } %>
        </select></p>
			<label for="note">Note</label><br> 
			<input type="text" name="note"><br> 
			<label for="rating">Rating</label><br> 
			<input type="number" name="rating" ><br>
			<input type="submit" value="Aggiungi"> 
			<input type="reset">
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
	<td><%=l.getRating()%></td> 


<% } %>
</table>

		<% } %>

		<form action="SceltaUtente">
		<input type="submit" name="scelta" value="Torna indietro"> 

		</form>

	</div>
</body>
</html>