<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="entity.*"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<TmdbRecomendados> listaRecomendados = (ArrayList<TmdbRecomendados>) request.getAttribute("listaRecomendados");
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
   
    <title> WRC FILMES</title>
    <link rel="icon" href="imagens/favicon.png">
  </head>
  <body>
      
    <nav class="navbar navabr-fixed-top navbar-inverse navbar-trasparente">
      <div class="container">
        <!--header-->
        <div class="navbar-header">
           <!--botão toggle-->
           <button type="button" class="navbar-toggle collapsed" data-toggle="Collapse" data-target="#barra-navegacao">
             <span class="sr-only">Alterar navegacao</span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
           </button>

          <a href="index.jsp" class="navbar-brand">
            <span class="img-logo">Spotify</span>
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
      </div> <!--container-->
    </nav>  <!--nav-->

    <div class="capa">
      <div class="texto-capa">
        <h3>Bem-Vindo(a) <br>
          Milhões de Filmes, Séries e Pessoas para Descobrir. Explore já.</h3>
           <a href="dashboard.jsp" class="btn btn-custom btn-roxo btn-lg">Gerar Dashbord</a>
        
        
      </div>
    </div>

    <!--Scroll filmes-->
    <section id="servicos">
      <div class="container">
        <div class="row" >
          
          <div class="col-md-6">
            <div class="row albuns">
               <div class="col-md-6">
                <div class="carousel">
                  <div class="carouselbox">
                    <!-- Random Data will come here  -->
                  </div>
            
                  <a class="switchLeft sliderButton" onclick="sliderScrollLeft()">
                  	<img alt="" src="imagens/less_than_30px.png">
                  </a>
                  
                  <div class="card-body table-responsive p-0" style="height: 790px;">
						<table class="table table-head-fixed text-nowrap"
							id="content-tabble">

							<%
							for (int i = 0; i < listaRecomendados.size(); i++) {
							%>
							<div>
								<div class="movieRow--listarea">
									<div class="movieRow--list">
										<div class="movieRow--item">
											<img
												src="https://image.tmdb.org/t/p/w300<%=listaRecomendados.get(i).getPoster_path()%>" />
										</div>
									</div>
								</div>
							</div>
							<%
							}
							%>
						</table>
					</div>
                  
                  <a class="switchRight sliderButton" onclick="sliderScrollRight()">
                  	<img alt="" src="imagens/iphone3.png">
                  </a>
                </div>
                
              </div>

            </div> 
        </div>
      </div>
    </section>

      <!--recursos-->
   

    <!--Rodapé-->
    <footer id="rodape">
      <div class="container">
        <div class="row">
          <div class="col-md-2">
            <span class="img-logo">Spotify</span>
          </div>

         

          <div class="col-md-2">
            <h4>Trabalho Realizado Por:</h4>
            <ul class="nav">
              <li><a href="">Pedro Belão</a></li>
              <li><a href="">Ricardo Venâncio</a></li>
              <li><a href="">Willian Cavalcante</a></li>
            </ul>
          </div>

          <div class="col-md-2">
            <h4>Links uteis</h4>
            <ul class="nav">
              <li><a href="">Ajuda</a></li>
              <li><a href="">Presentes</a></li>
              <li><a href="">Player da web</a></li>
            </ul>
          </div>

          <div class="col-md-2">
            <ul class="nav">
              <li class="item-rede-social"><a href=""><img src="imagens/facebook.png"></a></li>
              <li class="item-rede-social"><a href=""><img src="imagens/twitter.png"></a></li>
              <li class="item-rede-social"><a href=""><img src="imagens/instagram.png"></a></li>
            </ul>
          </div>

        </div>
        
      </div>
    </footer>

     <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

     <!-- Include all compiled plugins (below), or include individual files as needed -->
     <script src="bootstrap/js/bootstrap.min.js"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.20.0/axios.js"></script>
    <script src="./index.js"></script>
  </body>
</html>