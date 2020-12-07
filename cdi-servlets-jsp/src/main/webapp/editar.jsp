<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Actualizar los datos de la Persona</h2>
<!-- se maneja atraves del metodo doPost del servlet -->

	<form action="crudPersona?action=editar" method="post">
		Id: <input type="text" name="txtId" id="idPersona" value="${persona.id }" readonly="readonly"/> <br> <br>
		Nombre: <input type="text" name="txtNombre" id="nombrePersona" value="${persona.nombre }"/> <br> <br>
		Direccion: <input type="text" name="txtDireccion" id="direccionPersona" value="${persona.direccion }"/> <br> <br>
		Correo: <input type="text" name="txtCorreo" id="correoPersona" value="${persona.correo }"/> <br>
		<br>
		
		<input type="submit" name="btnCrear" value="Editar Persona">
		<br>
		<br>
		<a href="crudPersona?action=listar">
		<input type="button" name="btnCancelar" value="Cancelar">
		</a>
	</form>
</body>
</html>