<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="entity.*"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<TmdbRecomendados> listaRecomendados = (ArrayList<TmdbRecomendados>) request.getAttribute("listaRecomendados");
%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">

<script
	src="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/js/adminlte.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/css/adminlte.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
	integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
	integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous"></script>

<style type="text/css">
#content-tabble {
	border-collapse: collapse;
	margin: 25px 0;
	font-size: 0.9em;
	min-width: 400px;
	overflow: hidden;
	border-radius: 5px 5px 0 0;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

#content-tabble tbody tr {
	border-bottom: 1px solid #dddddd;
}

#content-tabble tbody tr:nth-of-type(even) {
	background-color: #f3f3f3;
}

#content-tabble tbody tr:last-of-type {
	border-bottom: 2px solid #009879;
}

#content-tabble tbody tr.active-row {
	font-weight: bold;
	color: Grey;
}

#BT {
	height: 50px;
	width: 200px;
	background-clip: content-box;
	color: gray;
	border-radius: 5px;
	border-bottom-left-radius: inherit;
	font-size: 17px;
	font-style: oblique;
	overflow: hidden;
	border-radius: 5px 5px 0 0;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

#content-tabble th {
	background-color: red;
	font-size-adjust: none;
}

body h1 {
	font-style: italic;
	font-size: 30px;
}

.movieRow{
  margin-bottom:  30px;
}
.movieRow h2 {
  margin: 0px 0px 0px 30px;
}
.movieRow--listarea {
  overflow-x: hidden;
  padding-left: 30px;
}
.movieRow--list {
  width: 999999px;
}
.movieRow--item{
  display: inline-block;
  width: 150px;
  cursor: pointer;
}
.movieRow--item img {
  width: 100%;
  transform: scale(0.9);
  transition: all ease 0.2s;
}
.movieRow--item img:hover{
  transform: scale(1);
}
</style>

</head>
<body>
	<nav class="main-header navbar navbar-expand navbar-white navbar-light">
		<!-- Left navbar links -->
		<ul class="navbar-nav">
			<li class="nav-item d-none d-sm-inline-block">
				<h1>Filme</h1>
			</li>
		</ul>
	</nav>

	<!--<aside class="main-sidebar sidebar-dark-primary elevation-4">
		<div class="sidebar">
			<nav class="mt-2">
				<ul class="nav nav-pills nav-sidebar flex-column"
					data-widget="treeview" role="menu" data-accordion="false">
					<li class="nav-item"><a
						href="http://localhost:8081/infomoney/viewdollar/Dashboard.jsp"
						class="nav-link"> <i class="nav-icon fas fa-home"></i>
							<p>Dashboard</p>
					</a></li>
				</ul>
			</nav>
		</div>
	</aside> -->
	<div class="container">
		<div class="row">
			<div class="col-xl-11 ">
				<div class="card">
					<!-- /.card-header -->
					<div class="card-body table-responsive p-0" style="height: 790px;">
						<table class="table table-head-fixed text-nowrap"
							id="content-tabble">

							<%
							for (int i = 0; i < listaRecomendados.size(); i++) {
							%>
							<div>
								<div className="movieRow--listarea">
									<div className="movieRow--list">
										<div className="movieRow--item">
											<img
												src="https://image.tmdb.org/t/p/w300<%=listaRecomendados.get(i).getPoster_path()%>" />
										</div>
									</div>
								</div>
							</div>
							<%
							}
							%>

							</tbody>
						</table>
					</div>
				</div>
			</div>


		</div>
		<form action="filmez" method="POST">
			<button class="btn btn-danger" type="submit">Atualizar
				valores</button>
		</form>
		<div class="modal fade" id="modal-xl" style="display: none;"
			aria-hidden="true">
			<div class="modal-dialog modal-xl">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Filmes</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="card-body table-responsive p-0" style="height: 790px;">
						<table class="table table-head-fixed text-nowrap"
							id="content-tabble">
							<thead>
								<tr class="active-row">
								<tr>
									<th>ID</th>
									<th>ORIGINAL TITLE</th>
									<th>TITLE</th>
									<th>ORGIRINAL LANGUAGE</th>
									<th>OVERVIEW</th>
									<th>POSTER PATH</th>
									<th>RELEASE DATE</th>
									<th>MEDIA TYPE</th>
									<th>VOTE AVARENGE</th>
								</tr>
							</thead>

						</table>
					</div>
					<div class="modal-footer justify-content-between">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	</div>
</body>
</html>