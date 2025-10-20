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
					<h1>Voici les disponibilités des médécins</h1>
				</div>
				</div>
				<div class="table-data">
				<div class="order">
				
				<c:forEach var="med" items = "${lst_med}">
				
				<div class="head">
						<h3>${med.nom} ${med.prenom}</h3>
				</div>
<table>
<thead>
<tr>
<th>Jour</th>
	<th>Heure début</th>
	<th>Heure fin</th>
	<th>Action</th>
</tr>
</thead>
<tbody>
<c:forEach var="disp" items = "${lst_disp}">
<c:if test="${disp.id_medF == med.id }">
<tr>
	<c:forEach var = "plg" items = "${lst_plg}">
		<c:if test="${plg.id_plg == disp.id_plgF}">
			<td>${disp.jour}</td>
			<td>${plg.heure_deb} h</td>
			<td>${plg.heure_fin} h</td>
			<td><a href="Disp_servlet?action=ajoutrdv&id_med=${med.id}&jour=${disp.jour}&id_plg=${plg.id_plg}&id_dispo=${disp.id}">Prendre un RDV</a></td>
		</c:if>
	</c:forEach>
</tr>
</c:if>
</c:forEach>
</tbody>
</table>

<br>
<br>

</c:forEach>
</div>
</div>

		</main>
		<!-- MAIN -->
	</section>
	<!-- CONTENT -->
	

	<script src="template/script.js"></script>
</body>
</html>