<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Biblioteca online</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body class="container">
	<h1 class="text-center">Cadastro de Autor</h1>
	<form action="<c:url value="/autores"/>" method="POST">
		
		<div class="form-group">
			<label for="nome">Nome:</label>
			<input id="nome" class="form-control" name="nome">
		</div>
		
		<div class="form-group">
			<label for="email">Email:</label>
			<input id="email" class="form-control" name="email">
		</div>
		
		<div class="form-group">
			<label for="data">Data de Nascimento:</label>
			<input id="data" class="form-control" name="data">
		</div>
		
		<div class="form-group">
			<label for="cv">Mini curriculo:</label>
			<input id="cv" class="form-control" name="cv">
		</div>
		
		<input type="submit" value="Gravar" class="mt-3 btn-primary">
	</form>
	
	<h1 class="text-center">Listagem do Autores</h1>
	
	<table class="table table-dark table-striped table-bordered">
		<thead>
			<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Data de Nascimento</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${gestao}" var="g">
				<tr>
					<td>${g.nome}</td>
					<td>${g.email}</td>
					<td>${g.data}</td>
				
				</tr>
				
			</c:forEach>
		
		
		</tbody>
	
	
	</table>
</body>
</html>