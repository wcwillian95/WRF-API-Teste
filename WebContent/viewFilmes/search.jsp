<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entity.*"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<TmdbRecomendados> listaSearch = (ArrayList<TmdbRecomendados>) request.getAttribute("listaPesquisa");
%>

<!doctype html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="estilo.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">

<title>WRC FILMES</title>

</head>
<body>

	<nav class="navbar navabr-fixed-top navbar-inverse navbar-trasparente">
		<div class="container">
			<!--header-->
			<div class="navbar-header">
				<!--botão toggle-->
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="Collapse" data-target="#barra-navegacao">
					<span class="sr-only">Alterar navegacao</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

				<a href="recomendados" class="navbar-brand"> <span
					class="img-logo"></span>
				</a>

			</div>

			<!--navbar-->
			<div class="collapse navbar-collapse" id="barra-navegacao">
				<ul class="nav navbar-nav navbar-right">

					<li><a href="">Filmes</a></li>
					<li><a href="">Series</a></li>
					<li><a href="">Perfil</a></li>
					<li class="divisor" role="separator"></li>
					<li><a href="">Inscreva-se</a></li>
					<li><a href="">Entrar</a></li>
				</ul>

			</div>
		</div>
		<!--container-->
	</nav>
	<!--nav-->

		<%
		for (int i = 0; i < listaSearch.size(); i++) {
		%>
	<div id="area-principal" class="container">
		<div id="postagem">
			<h3>
				<%=listaSearch.get(i).getOriginal_title()%>
			</h3>
			<span class="data-postagem">Data de lançamento: <%=listaSearch.get(i).getRelease_date() %></span>
			<img class="img-postagem"
				src="https://image.tmdb.org/t/p/w300<%=listaSearch.get(i).getPoster_path() %> "
				title="<%=listaSearch.get(i).getOriginal_title() %>"
				style="height: 200px; border-radius: 5px">
			<p>
				<%=listaSearch.get(i).getOverview() %>
			</p>
			<span class="postado">Nota Filme: <%=listaSearch.get(i).getVote_average() %></span>
		</div>
	</div>
		<%
		}
		%>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.20.0/axios.js"></script>
</body>
</html>