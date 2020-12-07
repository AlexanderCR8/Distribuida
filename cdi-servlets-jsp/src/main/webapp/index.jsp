<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">PAGINA WEB PARA  CREAR, ACTUALIZAR, LISTAR Y ELIMIMAR PERSONAS </h1>
	
	<div align="center">
	<input  type="button" value="Crear Persona" name="btnCrearPersona"
		onclick="location.href='crudPersona?action=crear'" />
	</div>
	<br/>
	<br/>
	<div align="center">
	<input type="submit" value="Listar Personas" name="btnListarPersonas" 
		onclick="location.href='crudPersona?action=listar'"/>
	</div>
	<h4 align="center"> En la tabla listar personas se encuntran los botones para eliminar y actualizar </h4>
	
</body>
</html>