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
				<a href="Login?action=Accueil_admin">
					<i class='bx bxs-dashboard' ></i>
					<span class="text">Accueil</span>
				</a>
			</li>
			<li  class="active">
				<a href="Medecin_servlet?action=list_med">
					<i class='bx bx-user'></i>
					<span class="text">Gestion des medecins</span>
				</a>
			</li>
			<li>
				<a href="Spec_servlet?action=list_spec">
					<i class='bx bxs-folder-minus'></i>
					<span class="text">Gestion des Spécialités</span>
				</a>
			</li>
			<li>
				<a href="RDV_servlet?action=rdvMed1">
					<i class='bx bx-list-ul'></i>
					<span class="text">Liste des RDV</span>
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
					<h1>Voici la liste des médécins</h1>
				</div>
				</div>
				<div class="table-data">
				<div class="order">
<table>
<thead>
<tr>
	<th>Nom</th>
	<th>Prenom</th>
	<th>Telephone</th>
	<th>Specialité</th>
</tr>
</thead>
<tbody>
<c:forEach var="med" items="${liste_med}">
<tr>
    <td>${med.nom}</td>
    <td>${med.prenom}</td>
    <td>${med.telephone}</td>
    <td>
        <c:forEach var="spec" items="${liste_spec}">
            <c:if test="${med.id_spe == spec.id}">
                ${spec.nom}
            </c:if>
        </c:forEach>
    </td>
   <td>
    <form action="Medecin_servlet" method="post" style="display:inline;">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="id" value="${med.id}">
        <button type="submit" style="border:none; background:none; cursor:pointer;">
            <i class='bx bx-trash' style="color:red; font-size:20px;"></i>
        </button>
    </form>
</td>

</tr>
</c:forEach>
</tbody>

</table>
</div>
</div>
			<div class="add-button">
                <a href="Medecin_servlet?action=form1" class="btn">
                    Ajouter un Médecin
                </a>
            </div>
            
		</main>
		<!-- MAIN -->
	</section>
	<!-- CONTENT -->
	

	<script src="template/script.js"></script>
</body>
</html>