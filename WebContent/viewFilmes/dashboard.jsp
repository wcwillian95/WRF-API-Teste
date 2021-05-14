<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="entity.DashboradRecom"%>
	<% DashboradRecom dash = (DashboradRecom) request.getAttribute("listaValores");%>
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
    <link rel="icon" href="imagens/cinema_64px.png">
  </head>
  <body>


    <nav class="navbar navabr-fixed-top navbar-inverse navbar-trasparente">
      <div class="container">
        <!--header-->
        <div class="navbar-header">
           <!--bot�o toggle-->
           <button type="button" class="navbar-toggle collapsed" data-toggle="Collapse" data-target="#barra-navegacao">
             <span class="sr-only">Alterar navegacao</span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
           </button>

          <a href="recomendados" class="navbar-brand">
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



      <!--recursos-->
    <section id="recursos">
      <div class="container">
        <div class="row">

          <div class="col-md-4" > 
           <div id="chart"></div>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', { packages: [ 'corechart' ] })
        google.charts.setOnLoadCallback(drawChart)
		const num5 = 2;
		console.log(num5)
        function drawChart() {
            const container = document.querySelector('#chart')
            const data = new google.visualization.arrayToDataTable([
                [ 'Notas', 'Filmes' ],
                [ 'De 5.0 at� 5.9', num5 ],
                [ 'De 6.0 at� 6,9', 2 ],
                [ 'De 7.0 at� 7,9 ', 7 ],
                [ 'De 8.0 at� 8,9', 9 ],
                [ 'De 9.0 at� max', 0 ]
            ])
            const options = {
                title: ' FILMES MAIS BEM AVALIADOS PELO IMDB POR NOTAS:',
                height: 400,
                width: 720
            }
            const chart = new google.visualization.ColumnChart(container)
            chart.draw(data, options)
        }


        
    </script>


<br>
 

<!--Dashbord 3-->
          <div id="chart2"></div>
            <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
            <script type="text/javascript">
            google.charts.load('current', { packages: [ 'corechart' ] })
            google.charts.setOnLoadCallback(drawChart)

            function drawChart() {
              const container = document.querySelector('#chart2')
              const data = new google.visualization.arrayToDataTable([
                  [ 'Character', 'Bilheteria', ],
                  [ 'Avatar', 2846089541 ],
                  [ 'Avengers: Endgame', 2797501328 ],
                  [ 'Titanic', 2201647264 ],
                  [ 'Star Wars: Episode VII', 2068455677 ],
                  [ 'Avengers: Infinity War', 2048359754 ]
              ])
              const options = {
                  title: 'TOP 5 FILMES COM MAIORES BILHETERIAS $$$  DE TODOS OS TEMPOS:',
                  height: 400,
                  width: 720,
                  is3D: true
              }
              const chart = new google.visualization.PieChart(container)
              chart.draw(data, options)
            }
            </script>
            <br>
            
          </div>
            </div>
          </div>
          
        </div>
      </div>
    </section>

     <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

     <!-- Include all compiled plugins (below), or include individual files as needed -->
     <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>