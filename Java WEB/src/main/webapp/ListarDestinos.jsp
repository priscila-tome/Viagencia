<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Destinos</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>


</head>
<body>

		<nav class="navbar navbar-expand-lg bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Administração Viagência</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Clientes </a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="listarClientes">Ver
										todos</a></li>
								<li><a class="dropdown-item" href="#">Editar dados do
										cliente</a></li>
								<li><a class="dropdown-item" href="#">Excluir cliente</a></li>
							</ul></li>

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Destinos </a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Adicionar destino</a></li>
								<li><a class="listarDestinos" href="#">Ver todos</a></li>
								<li><a class="dropdown-item" href="#">Editar destino</a></li>
								<li><a class="dropdown-item" href="#">Excluir destino</a></li>
							</ul></li>

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Hotéis </a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Adicionar hotél</a></li>
								<li><a class="dropdown-item" href="#">Ver todos</a></li>
								<li><a class="dropdown-item" href="#">Editar dados</a></li>
								<li><a class="dropdown-item" href="#">Excluir hotél</a></li>
							</ul></li>

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Voos </a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Adicionar voo</a></li>
								<li><a class="dropdown-item" href="#">Ver todos</a></li>
								<li><a class="dropdown-item" href="#">Alterar voo</a></li>
								<li><a class="dropdown-item" href="#">Excluir voo</a></li>
							</ul></li>

					</ul>
				</div>
			</div>
		</nav>
		
		<br>
		
		<div class="container">

		<h5>Clientes no banco de dados</h5>

		<table class="table">
			<thead>
				<tr>
					<th>CPF</th>
					<th>Nome</th>
					<th>Endereço</th>
					<th>Telefone</th>
					<th>Email</th>
					<th>Senha</th>
				</tr>
			</thead>
			<tbody>
				<jstl:forEach items="${listaDestinos}" var="destino">
					<tr>
						<td>${destino.Id_destino}</td>
						<td>${destino.pais}</td>
						<td>${destino.estado}</td>
						<td>${destino.cidade}</td>
						<td><a href="editar?id=${destino.id}" class="btn btn-success">Editar</a>
							<a href="excluir?id=${destino.id}"
							onclick="return confirm('Deseja Excluir?')"
							class="btn btn-danger">Excluir</a></td>
					</tr>
				</jstl:forEach>
			</tbody>
		</table>
		</div>
</body>
</html>