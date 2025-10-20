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
			<li >
				<a href="Spec_servlet">
					<i class='bx bxs-edit' ></i>
					<span class="text">Prendre un RDV</span>
				</a>
			</li>
			<li class="active">
				<a href="#">
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
			<a href="home.jsp" class="logout">
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
					<h1>Voici une liste de vos rendez vous</h1>
				</div>
				</div>
				<div class="table-data">
				<div class="order">
<table>
<thead>
<tr>
	<th>Medecin</th>
	<th>Jour</th>
	<th>Heure debut</th>
	<th>Heure fin</th>
</tr>
</thead>
<tbody>
<c:forEach var="rdv" items = "${liste_rdv}">
<tr>
	<c:forEach var = "med" items = "${liste_med}">
		<c:if test="${med.id == rdv.id_med}">
			<td>${med.nom} ${med.prenom}</td>
		</c:if>
	</c:forEach>
	
	<td>${rdv.jour}</td>
	
	<c:forEach var = "plg" items = "${liste_plg}">
		<c:if test="${plg.id_plg == rdv.id_plg}">
			<td>${plg.heure_deb} h</td>
			<td>${plg.heure_fin} h</td>
		</c:if>
	</c:forEach>
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