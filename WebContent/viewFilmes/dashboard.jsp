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

<title>WRC FILMES</title>
<link rel="icon" href="imagens/favicon.png">
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

				<a href="index.jsp" class="navbar-brand"> <span
					class="img-logo">Spotify</span>
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



	<!--recursos-->
	<section id="recursos">
		<div class="container">
			<div class="row">

				<div class="col-md-4">
					<div id="chart"></div>
					<script type="text/javascript"
						src="https://www.gstatic.com/charts/loader.js"></script>
					<script type="text/javascript">
						google.charts.load('current', {
							packages : [ 'corechart' ]
						})
						google.charts.setOnLoadCallback(drawChart)

						function drawChart() {
							const container = document.querySelector('#chart')
							const data = new google.visualization.arrayToDataTable(
									[ [ 'Character', 'Ki' ], [ 'Ação', 10000 ],
											[ 'Comedia', 9000 ],
											[ 'Drama', 8000 ],
											[ 'Terror', 5000 ],
											[ 'Piccolo', 2000 ] ])
							const options = {
								title : ' FILMES MAIS RECOMENDADOS DE 2021 POR GENÊRO',
								height : 400,
								width : 720
							}

							// const chart = new google.visualization.ColumnChart(container)
							// const chart = new google.visualization.BarChart(container)
							// const chart = new google.visualization.LineChart(container)
							const chart = new google.visualization.PieChart(
									container)
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

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>