<%@page import="java.util.List"%>
<%@page import="it.dstech.modelli.Eroe"%>
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
<title>Modifica Eroe</title>
</head>
<body>
<div class="center">
<%Eroe eroe = (Eroe) session.getAttribute("eroe");%>
<%GestioneBattleground gestione = new GestioneBattleground(); %>


 <h1>Inserisci le caratteristiche dell'eroe da modificare</h1>
 
	<form action="ModificaEroe" method="post" enctype="multipart/form-data">
	<label for="nomeEroe">Nome Eroe:</label><br>
   	<input type="text"  name="nome"  placeholder="<%=eroe.getNome()%>"/><br>
   		<p>Costo Eroe: <select name="costo">
         <option value="" disabled selected><%=eroe.getCosto()%></option>
         <%for(int i=0;i<=3;i++){%>
         <option value=<%=i%>> <%=i%>
         <% } %>
        </select></p>
    <label for="potere">PotereEroe:</label><br>
    <input type="text"  name="potere" placeholder="<%=eroe.getPotere()%>" /><br><br>
   	<label for="hp">HP Eroe:</label><br>
   	<input type="number"  name="HP" placeholder="<%=eroe.getHP()%>" /><br><br>	
   	<input type="file" name="image" placeholder="Inserisci l'immagine dell'eroe"><br>   
	<br><input type="submit" class = "button"  value="Modifica">
</form>

<form action="GestioneEroe" method="post">
<input type="submit" name="azione" value="Torna indietro">	
</form>
</div>
</body>
</html>