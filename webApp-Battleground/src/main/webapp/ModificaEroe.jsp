<%@page import="java.util.List"%>
<%@page import="it.dstech.modelli.Eroe"%>
<%@page import="it.dstech.gestione.GestioneBattleground"%>
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
<%Eroe eroe = (Eroe) request.getAttribute("eroe"); %>
<%GestioneBattleground gestione = new GestioneBattleground(); %>


 <h1>Inserisci le caratteristiche dell'eroe da aggiungere</h1>
 
	<form action="CreazioneEroe" method="post" >
	<label for="nome">Nome Eroe:</label><br>
   	<input type="text" class="button" name="nome"  placeholder="<%=eroe.getNome()%>"/><br>
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
    <input type="submit" name="azione" value="Torna indietro">	
</form>
</div>
</body>
</html>