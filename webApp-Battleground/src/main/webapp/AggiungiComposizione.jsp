<%@page import="it.dstech.modelli.Composizione"%>
<%@page import="java.util.List"%>
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
<%List<Composizione> listaComposizioni = (List<Composizione>)request.getAttribute("lista"); %>
<%GestioneBattleground gestione = new GestioneBattleground(); %>


 <h1>Inserisci la composizione</h1>
 
	<form action="AggiungiComposizione" method="post" >
	<label for="nome">Nome Composizione:</label><br>
   	<input type="text" class="button" name="composizione" /><br>
   		 
	<br><input type="submit" class = "button"  name ="azione" value="Aggiungi">
    <input type="submit" name="azione" value="Torna indietro">


			
<table>
	<tr>
	<th>Lista Composizioni</th></tr>
	<tr><td>Nome</td> 
	
  
	<% for(Composizione c : listaComposizioni){%>
<tr>

    <td><%=c.getNome()%></td> 
	

<% } %>
</table>
			
</form>
</div>

</body>
</html>