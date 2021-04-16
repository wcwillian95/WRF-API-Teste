<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

          <a href="index.html" class="navbar-brand">
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
          <!-- <a href="" class="btn btn-custom btn-roxo btn-lg">Aproveite o Spotify free</a>
        <a href="" class="btn btn-custom btn-branco btn-lg">Obter Spotify premium</a> -->
        
      </div>
    </div>

    <!--conteudo-->
    <section id="servicos">
      <div class="container">
        <div class="row" >
          
          <div class="col-md-6">
            <div class="row albuns">
<!--                <div class="col-md-6"> -->
<!--                 <img src="imagens/img2.jpg" class="img-responsive"> -->
<!--               </div> -->

<!--               <div class="col-md-6"> -->
<!--                 <img src="imagens/img4.jpg" class="img-responsive"> -->
<!--               </div> -->

<!--             </div>  -->
              

            <!-- <div class="row albuns">

              <div class="col-md-6" ">
                <img src="imagens/img3.jpg" class="img-responsive">
              </div>

              <div class="col-md-6">
                <img src="imagens/img1.jpg" class="img-responsive">
              </div>

            </div>

          </div> -->
            


          <!--<div class="col-md-6">
            <h2>Oque é o Spotify?</h2>

            <h3>Músicas</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris mollis, dolor nec accumsan ullamcorper, purus sem vulputate odio, euismod rutrum leo arcu at enim. Phasellus faucibus nulla congue porta hendrerit</p>

            <h3>Playlists</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris mollis, dolor nec accumsan ullamcorper, purus sem vulputate odio, euismod rutrum leo arcu at enim. Phasellus faucibus nulla congue porta hendrerit</p>

            <h3>Lançamentos</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris mollis, dolor nec accumsan ullamcorper, purus sem vulputate odio, euismod rutrum leo arcu at enim. Phasellus faucibus nulla congue porta hendrerit</p>

            
          </div>-->
          

        </div>
      </div>
    </section>

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
        

        function drawChart() {
            const container = document.querySelector('#chart')
            const data = new google.visualization.arrayToDataTable([
                [ 'Filmes', 'Ki' ],
                [ 'SONIC: O FILME', 10000 ],
                [ 'BAD BOYS PARA SEMPRE', 9000 ],
                [ 'AVES DE RAPINA', 8000 ],
                [ 'O HOMEM INVISÍVEL', 5000 ],
                [ 'JOIAS BRUTAS', 2000 ]
            ])
            const options = {
                title: 'Filmes mais pesquisados de 2020.',
                height: 400,
                width: 720
            }

            // const chart = new google.visualization.ColumnChart(container)
            // const chart = new google.visualization.BarChart(container)
            // const chart = new google.visualization.LineChart(container)
            const chart = new google.visualization.PieChart(container)
            chart.draw(data, options)
        }
    </script>
          </div>

          <!--img recursos-->
          <div class="col-md-8">
             <!-- <div class="row rotacionar">

              <div class="col-md-4" ">
                <img src="imagens/iphone1.png" class="img-responsive">
              </div>

              <div class="col-md-4">
                <img src="imagens/iphone2.png" class="img-responsive">
              </div>--> 
           

    

            </div>
          </div>
          
        </div>
      </div>
    </section>

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
  </body>
</html>