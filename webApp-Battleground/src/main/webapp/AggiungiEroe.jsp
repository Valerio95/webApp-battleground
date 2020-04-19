<%@page import="java.util.List"%>
<%@page import="it.dstech.modelli.Eroe"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/buttons.css" rel="stylesheet" type="text/css">
<link href="css/background.css" rel="stylesheet" type="text/css">
<link href="css/text.css" rel="stylesheet" type="text/css">
<link href="css/table.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Eroe</title>
</head>
<body class="background">
<div class="center">
 <h1>Inserisci le caratteristiche dell'eroe da aggiungere</h1>
	<form action="CreazioneEroe" method="post">
   		Nome Eroe:<input type="text" name="Nome" /><br><br>
   		Costo Eroe:<input type="number" name="costo" /><br><br>
   		Potere eroe:<input type="text" name="potere" /><br><br>
   	<input type="file" name="image" placeholder="Inserisci l'immagine dell'eroe"><br>   
	<br><input type="submit" class = "buttons"  name ="azione" value="Aggiungi">
</form>
</div>
</body>
</html>