<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
			<h1>Benvenuto Amministratore</h1>

			<br>Qui puoi gestire la tua applicazione.<br>


		Seleziona un'opzione:

		<form action="SceltaAdmin">
	<input type="submit"  class = "button " name ="azione" value="Aggiungi/RimuoviEroe" /> <br><br>
	<input type="submit"  class = "button " name ="azione" value="Aggiungi/RimuoviComposizione" /> <br><br>
	
		</form>
		
		<% } %>

	</div>
</body>
</html>