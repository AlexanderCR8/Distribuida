<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h2>Ingresar datos de la Persona</h2>
	
<!-- se maneja atraves del metodo doPost del servlet -->
	
	<form action="crudPersona?action=insertar" method="post">
		Nombre: <input type="text" name="txtNombre" id="nombre"/> <br> <br>
		Direccion: <input type="text" name="txtDireccion" id="direccion"/> <br> <br>
		Correo: <input type="text" name="txtCorreo" id="correo"/> <br> <br>
		
		
		<input type="submit" name="btnCrear" value="Crear Persona">
		<a href="crudPersona?action=index">
		<input type="button" name="btnCancelar" value="Cancelar">
		</a>
		
	</form>
	
	
</body>
</html>