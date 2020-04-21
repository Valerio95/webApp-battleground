<%@page import="java.util.List"%>
<%@page import="it.dstech.modelli.Eroe"%>
<%@page import="it.dstech.gestione.GestioneBattleground"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/Admin.css" rel="stylesheet" type="text/css">
<link href="css/Default.css" rel="stylesheet" type="text/css">
<link href="css/text.css" rel="stylesheet" type="text/css">
<link href="css/table.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Eroe</title>
</head>
<body class="background">
<div class="center">
<%List<Eroe> listaEroi = (List<Eroe>)request.getAttribute("lista"); %>
<%GestioneBattleground gestione = new GestioneBattleground(); %>
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

<img alt="immagine" src="data:image/jpg;base64,<%=gestione.getImageEroeString(l)%>"> <br>

</td> 
<% } %>
</table>
 <h1>Inserisci le caratteristiche dell'eroe da aggiungere</h1>
 
	<form action="CreazioneEroe" method="post" enctype="multipart/form-data">
   		Nome Eroe:<input type="text" name="nome" /><br><br>
   		<p>Costo Eroe: <select name="costo">
         <%for(int i=0;i<=3;i++){%>
      <option value=<%=i%> > <%=i%>
         <% } %>
         </select></p> /><br><br>
   		Potere eroe:<input type="text" name="potere" /><br><br>
   		HP Eroe:<input type="number" name="HP" /><br><br>
   	<input type="file" name="image" placeholder="Inserisci l'immagine dell'eroe"><br>   
	<br><input type="submit" class = "buttons"  name ="azione" value="Aggiungi">
</form>
</div>
<form action="SceltaAdmin">
		<input type="submit" name="azione" value="Torna indietro">
		
		</form>
</body>
</html>