<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ page import="entity.*" %>
		<%@ page import="java.util.ArrayList" %>
			<% Filme x=(Filme) request.getAttribute("detailMovie"); %>

				<!doctype html>
				<html lang="pt-br">

				<head>
					<meta charset="utf-8">
					<meta http-equiv="X-UA-Compatible" content="IE=edge">
					<meta name="viewport" content="width=device-width, initial-scale=1">

					<!-- Bootstrap CSS -->
					<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
					<link rel="stylesheet" href="estilo.css">
					<link rel="stylesheet" href="css/style.css">
					<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">

					<title>WRC FILMES</title>

				</head>

				<body>

					<nav class="navbar navabr-fixed-top navbar-inverse navbar-trasparente">
						<div class="container">
							<!--header-->
							<div class="navbar-header">
								<!--bot�o toggle-->
								<button type="button" class="navbar-toggle collapsed" data-toggle="Collapse"
									data-target="#barra-navegacao">
									<span class="sr-only">Alterar navegacao</span> <span class="icon-bar"></span> <span
										class="icon-bar"></span> <span class="icon-bar"></span>
								</button>

								<a href="recomendados" class="navbar-brand"> <span class="img-logo"></span>
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
					</nav>
					<!--nav-->
					<!--container1-->
					<section class="inner_content movie_content backdrop poster">
						<div class="header large border first">
							<div class="keyboard_s custom_bg">
								<div class="single_column">
									<section id="original_header" class="images inner">
										<div class="poster_wrapper false">
											<div class="poster">
												<div class="image_content backdrop">
													<img src="https://image.tmdb.org/t/p/w300_and_h450_bestv2<%=x.getPoster_path()%>" alt=""
														class="poster lazyload lazyloaded">
												</div>
												<div class="zoom">
													<a href="#" class="no_click">
														<span class="fullscreen white"></span>
														"Expandir"
													</a>
												</div>
											</div>
										</div>
										<div class="header_poster_wrapper false">
											<section class="header poster">
												<div class="title ott_false" dir="auto">
													<h2 class="17">
														<a href="#">
															<%=x.getOriginal_title() %>
														</a>
														<span class="tag release_date">(<%=x.getRelease_date().substring(0, 4) %>)</span>
													</h2>
													<div class="facts">
														<span class="release">
															<%=x.getRelease_date() %> (BR)
														</span>
														<span class="genres">
															<% for(Genres y : x.getGenres()){ %>
																<a>
																	<%=y.getName() %> - 
																</a>
																<% } %>
														</span>
														<span class="runtime">
															<%=x.getRuntime() %>
														</span>
													</div>
												</div>
												<ul class="auto actions">
													<li class="chart">
														<div class="consensus details">
															<h3><%=x.getVote_average() %></h3>
														</div>
														<div class="text">Avaliacao<br>dos<br>usuarios</div>
													</li>
													<li>
														<a href="#" title="Favoritos">
															<img src="imagens/heart.png" width="20px" height="20px" style="color: white;"/>
														</a>
													</li>
													<li class="video none">
														<a class="no_click play_trailer" href="#" data-site="YouTube" data-id="kIET9yMABD8"
															data-title="Reproduzir trailer"> Reproduzir
															trailer</a>
													</li>
												</ul>
												<div class="header_info"></div>
											</section>
										</div>
									</section>
								</div>
							</div>
						</div>
					</section>
					<!--container1-->

					<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
					<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

					<!-- Include all compiled plugins (below), or include individual files as needed -->
					<script src="bootstrap/js/bootstrap.min.js"></script>
					<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.20.0/axios.js"></script>
				</body>

				</html>