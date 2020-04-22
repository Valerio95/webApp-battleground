<%@page import="it.dstech.modelli.Eroe"%>
<%@page import="java.util.List"%>
<%@page import="it.dstech.gestione.GestioneBattleground"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/Default.css" rel="stylesheet" type="text/css">
<link href="css/text.css" rel="stylesheet" type="text/css">
<link href="css/table.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Rimozione eroe</title>
</head>
<body class="background">
  <div class="center">
<%GestioneBattleground gestione = new GestioneBattleground(); %>

    <% String messaggio = (String) request.getAttribute("messaggio"); 
  if (messaggio != null ){
    %>
    <h1>ERRORE</h1>
    <%=messaggio%>
    <% }
  else {
%>

    <%List<Eroe> listaEroi = (List<Eroe>)request.getAttribute("lista");%>
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
<td>
Immagine eroe</td>    

  
<% for(Eroe l : listaEroi){
  String nomeEroe = l.getNome();
%>

<tr>

  <td><%=l.getNome()%> </td> 
  <td><%=l.getPotere()%></td>
  <td><%=l.getCosto()%></td> 
  <td><%=l.getHP()%></td> 
  <td><img alt="immagine" src="data:image/jpg;base64,<%=gestione.getImageEroeString(l)%>"> <br></td> 

  <td>
    <form action="GestioneEroe" method="post">
    <input type="hidden" name ="eroeDaRimuovere" value="<%=nomeEroe%>"><br><br>
    <% session.setAttribute("eroe", l); %>
    <input type="submit" name="scelta" value="Modifica">
    <input type="submit" name="scelta" value="Rimuovi">
</form></td> 

<% } %>
</table>
    
    <% } %>
    <form action="SceltaAdmin" method="post">
    <input type="submit" name="azione" value="Torna indietro">
    
    </form>
  </div>
</body>
</html>
