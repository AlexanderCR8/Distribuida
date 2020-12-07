<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Lista de Personas</h1>
	
			
	<table border="1" style="background-color:#B4E9E9" align="center">
		<tr>
			<td><b>Id</b></td>
			<td><b>Nombre</b></td>
			<td><b>Direccion</b></td>
			<td><b>Correo electronico</b></td>
			
			<td colspan=2></td>
		</tr>
		<c:forEach var="persona" items="${lista}">
			<tr>
				<td>${persona.id }</td>
				<td>${persona.nombre }</td>
				<td>${persona.direccion }</td>
				<td>${persona.correo }</td>
				
				<td><a href="crudPersona?action=mostrarEditar&id=${persona.id}">
				<input type="button" value="Actualizar"></a></td>
				
				<td><a href="crudPersona?action=eliminar&id=${persona.id}">
				<input type="button" style="background-color:#E88373 " value="Eliminar"></a></td>
			</tr>
		</c:forEach>
		
	</table>
	<br>
	<div align="center">
	<a href="crudPersona?action=index"  >
	<input type="button"  value="Ir al menú"></a>
	</div>
	
	
	
</body>
</html>