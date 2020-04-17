<%@page import="java.util.List"%>
<%@page import="it.dstech.modelli.Eroe"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Eroe> listaEroi = (List<Eroe>)session.getAttribute("lista"); %>




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
Immagine</td>    

  
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
<%=l.getImage()%>
</td> 
<td>
<form action="rimuoviEroe" method="post">
<input type="number" hidden="true" name ="nomeEroe" value=<%=l.getNome()%>><br><br>

<input type="submit" class = "button newClass"  name ="azione" value="Rimuovi">

</form>
</td> 
<% } %>
</table>
 <div class="center">
<form action="aggiungi/rimuoviEroe" method="post">
   Nome Eroe:<input type="text" name="Nome" /><br><br>
   Costo Eroe:<input type="number" name="costo" /><br><br>
   Potere eroe:<input type="text" name="potere" /><br><br>
   <input type="file" name="image" placeholder="Inserisci l'immagine dell'eroe">   
<input type="submit" class = "button newClass"  name ="azione" value="Aggiungi">


</form>
</div>
</body>
</html>