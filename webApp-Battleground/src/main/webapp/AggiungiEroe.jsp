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
<title>Eroe</title>
</head>
<body>
<div class="center">
<%List<Eroe> listaEroi = (List<Eroe>)request.getAttribute("lista"); %>
<%GestioneBattleground gestione = new GestioneBattleground(); %>


 <h1>Inserisci le caratteristiche dell'eroe da aggiungere</h1>
 
	<form action="CreazioneEroe" method="post" enctype="multipart/form-data">
	<label for="nome">Nome Eroe:</label><br>
   	<input type="text" class="button" name="nome" /><br>
   		<p>Costo Eroe: <select name="costo">
         <%for(int i=0;i<=3;i++){%>
         <option value=<%=i%> > <%=i%>
         <% } %>
        </select></p>
     <label for="potere">PotereEroe:</label><br>
     <input type="text" class="button" name="potere" /><br><br>
   	 <label for="hp">HP Eroe:</label><br>
   	 <input type="number" class="button" name="HP" /><br><br>
   		
   	<input type="file" name="image" placeholder="Inserisci l'immagine dell'eroe"><br>   
	<br><input type="submit" class = "button"  name ="azione" value="Aggiungi">
   


		<h1>Lista Eroi	</h1>
<table>
	
	<tr><td>Nome</td> 
	<td>Potere</td> 
	<td>Costo</td> 
	<td>HP</td>    
	<td>Immagine eroe</td> 
  
	<% for(Eroe l : listaEroi){%>
<tr>

    <td><%=l.getNome()%></td> 
	<td><%=l.getPotere()%></td>
	<td><%=l.getCosto()%></td> 
	<td><%=l.getHP()%></td> 

<td>

<img class="cornice-foto" alt="immagine" src="data:image/jpg;base64,<%=gestione.getImageEroeString(l)%>"> <br>

</td> 
<% } %>
</table>
			
</form>


 <form action="SceltaAdmin">
 <input type="submit" name="azione" value="Torna indietro">
 </form>

	</div>	
</body>
</html>