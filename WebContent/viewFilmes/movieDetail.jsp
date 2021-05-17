<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entity.*"%>
<%@ page import="java.util.ArrayList"%>
<%
Filme x = (Filme) request.getAttribute("detailMovie");
Images img = (Images) request.getAttribute("imagesMovie");
Elenco elenco = (Elenco) request.getAttribute("castDetail");
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
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">

<title>WRC FILMES</title>

</head>

<body>

	<nav class="navbar navabr-fixed-top navbar-inverse navbar-trasparente">
		<div class="container">
			<!--header-->
			<div class="navbar-header">
				<!--bot�o toggle-->
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
	</nav>
	<!--nav-->
	<!--container1-->
	<section class="inner_content movie_content backdrop poster">
		<div class="header large border first"
			style="background-image: url('https://image.tmdb.org/t/p/original<%=img.getBackdrops()[0].getFile_path()%>');">
			<div class="keyboard_s custom_bg">
				<div class="single_column">
					<section id="original_header" class="images inner">
						<div class="poster_wrapper false">
							<div class="poster">
								<div class="image_content backdrop">
									<img
										src="https://image.tmdb.org/t/p/w300_and_h450_bestv2<%=x.getPoster_path()%>"
										alt="" class="poster lazyload lazyloaded">
								</div>
								<div class="zoom">
									<a href="#" class="no_click"> <span
										class="fullscreen white"></span> "Expandir"
									</a>
								</div>
							</div>
						</div>
						<div class="header_poster_wrapper false">
							<section class="header poster">
								<div class="title ott_false" dir="auto">
									<h2 class="17">
										<a href="#"> <%=x.getOriginal_title()%>
										</a> <span class="tag release_date">(<%=x.getRelease_date().substring(0, 4)%>)
										</span>
									</h2>
									<div class="facts">
										<span class="release"> <%=x.getRelease_date()%> (BR)
										</span> <span class="genres"> <%
										 for (Genres y : x.getGenres()) {
										 %> <a> <%=y.getName()%> -
										</a> <%
										 }
										 %>
										</span> <span class="runtime"> <%=x.getRuntime()%>
										</span>
									</div>
								</div>
								<ul class="auto actions">
									<li class="chart">
										<div class="consensus details">
											<h3><%=x.getVote_average()%></h3>
										</div>
										<div class="text">
											Avaliacao<br>dos<br>usuarios
										</div>
									</li>
									<li><a href="#" title="Favoritos"> <img
											src="imagens/heart.png" width="20px" height="20px"
											style="color: white;" />
									</a></li>
									<li class="video none"><a class="no_click play_trailer"
										href="#" data-site="YouTube" data-id="kIET9yMABD8"
										data-title="Reproduzir trailer"> Reproduzir trailer</a></li>
								</ul>
								<div class="header_info">
									<h3 class="tagline" dir="auto">
										<%=x.getTagline()%>
									</h3>
									<h3 dir="auto">Sinopse</h3>
									<div class="overview" dir="auto">
										<p>
											<%=x.getOverview()%>
										</p>
									</div>
								</div>
							</section>
						</div>
					</section>
				</div>
			</div>
		</div>
	</section>
	<!--container1-->
		<!--container2-->
	<style>
		 
/*Elenco*/
div.media.movie_v4, div.media.tv_v4, div.media.person_v4, div.media.collection_v4 {
  margin-top: 0;
  margin-bottom: 0;
  background-color: #fff;
  width: 100%;
}
div.media {
  width: 100%;
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  align-items: flex-start;
  align-content: flex-start;
}
div.column_wrapper {
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: flex-start;
  align-content: flex-start;
}
div.column_wrapper div.content_wrapper {
  width: 100%;
  display: flex;
  align-items: flex-start;
  align-content: flex-start;
  padding-left: 40px;
  padding-right: 40px;
  padding-top: 30px;
  padding-bottom: 30px;
}
div.white_column {
  background-color: #fff;
  width: calc(100vw - 80px - 268px);
  max-width: calc(0 - 80px - 268px);
  display: flex;
  flex-wrap: wrap;
  flex: 0 1 auto;
  padding-right: 30px;
}
div.scroller_wrap {
  position: relative;
  top: 0;
  left: 0;
}
ol.people.scroller {
  overflow-y: hidden;
  overflow-x: scroll;
  margin-left: -10px;
  margin-top: -10px;
  padding-bottom: 10px;
}
ol.people {
  list-style-type: none;
  list-style-position: inside;
  margin: 0;
  padding: 0;
  display: flex;
  position: relative;
  top: 0;
  left: 0;
}
ol.people li.card {
  margin-top: 10px;
  margin-bottom: 10px;
  margin-left: 10px;
  margin-right: 4px;
  border: 1px solid rgba(227,227,227, 1);
  padding-bottom: 10px;
  border-radius: 8px;
}
/*Elenco*/
	</style>
	<div class="media tv_v4 header_large">
		<div class="column_wrapper">
			<div class="content_wrapper">
				<div>
					<div class="white_column">
						<section class="panel top_billed scroller">
							<h3 dir="auto">Elenco da Serie</h3>
							<div class="scroller_wrap should_fade is_fading">
								<ol class="people scroller">
								<%for(int i = 0; i < 10; i++){ %>
									<li class="card">
										<a href="#">
											<img loading="lazy" src="https://image.tmdb.org/t/p/w138_and_h175_face<%=elenco.getCast()[i].getProfile_path() %>" alt="">
										</a>
										<p>
											<a href="#"><%=elenco.getCast()[i].getName() %></a>
										</p>
										<p class="character">
											<%=elenco.getCast()[i].getCharacter()%>
										</p>
									</li>
									<%}%>
								</ol>
							</div>
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--container2-->
	
	
	
	<!-- 
	<div class="videoContainer">
		<iframe width="560" height="315" disable="true"
			src="https://www.godzillavskong.net/"
			allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
			allowfullscreen></iframe>
	</div>

	<style type="text/css">
.k-overlay {
	width: 100%;
	height: 100%;
	background-color: #000;
	opacity: .5;
	position: fixed;
	top: 0;
	left: 0;
	z-index: 10001;
}

.videoContainer {
	position: absolute;
	width: 100%;
	height: 100%;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

iframe {
	/* optional */
	width: 50%;
	height: 50%;
}
</style>
 -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.20.0/axios.js"></script>
</body>

</html>