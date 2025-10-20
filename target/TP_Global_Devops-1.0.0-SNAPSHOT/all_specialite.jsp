<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- Boxicons -->
	<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
	<!-- My CSS -->
	<link rel="stylesheet" href="template/style.css">
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<title>Gestion RDV</title>
</head>
<body>


	<!-- SIDEBAR -->
	<section id="sidebar">
		<a href="#" class="brand">
			<i class='bx bxs-smile'></i>
			<span class="text">Gestion RDV</span>
		</a>
		<ul class="side-menu top">
			<li >
				<a href="Login?action=accueil">
					<i class='bx bxs-dashboard' ></i>
					<span class="text">Accueil</span>
				</a>
			</li>
			<li class="active">
				<a href="#">
					<i class='bx bxs-edit' ></i>
					<span class="text">Prendre un RDV</span>
				</a>
			</li>
			<li>
				<a href="RDV_servlet?action=list_rdv">
					<i class='bx bxs-calendar' ></i>
					<span class="text">Mes RDV</span>
				</a>
			</li>
		</ul>
	</section>
	<!-- SIDEBAR -->



	<!-- CONTENT -->
	<section id="content">
		<!-- NAVBAR -->
		<nav>
			<i class='bx bx-menu' ></i>
			<a href="#" class="logout">
					<i class='bx bxs-log-out-circle' ></i>
					<span class="text">Logout</span>
				</a>
			<a href="#" class="profile">
				<img src="template/img/people.png">
			</a>
		</nav>
		<!-- NAVBAR -->

		<!-- MAIN -->
		<main>
		<div class="head-title">
				<div class="left">
					<h1>Quelle spécialité souhaitez vous?</h1>
				</div>
				</div>
				<div class="table-data">
				<div class="order">
<table>
<thead>
<tr>
<th>Spécialité</th>
</tr>
</thead>
<tbody>
<c:forEach var="spe" items="${liste_spe}" >
<tr>
<td><a href = "Disp_servlet?id_spec=${spe.id}&action=list_disp" > ${spe.nom} </a></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
			
		</main>
		<!-- MAIN -->
	</section>
	<!-- CONTENT -->
	

	<script src="template/script.js"></script>
</body>
</html>