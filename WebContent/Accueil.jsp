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
			<li class="active">
				<a href="#">
					<i class='bx bxs-dashboard' ></i>
					<span class="text">Accueil</span>
				</a>
			</li>
			<li>
				<a href="Spec_servlet">
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
			
			<h1>Statistiques des médecins par spécialité</h1>
    <canvas id="doctorsChart" width="400" height="400"></canvas>

    <script>
        // Préparer les données pour le graphique
        const labels = [
        <c:set var="count" value="0" />
        <c:set var="size" value="${fn:length(datamed)}" />
        <c:forEach var="entry" items="${datamed}">
            '${entry.key}'<c:if test="${count < size - 1}">,</c:if>
            <c:set var="count" value="${count + 1}" />
        </c:forEach>
    ];

    const data = [
        <c:set var="count" value="0" />
        <c:forEach var="entry" items="${datamed}">
            ${entry.value}<c:if test="${count < size - 1}">,</c:if>
            <c:set var="count" value="${count + 1}" />
        </c:forEach>
    ];

        // Initialiser le pie chart
        const ctx = document.getElementById('doctorsChart').getContext('2d');
        const doctorsChart = new Chart(ctx, {
            type: 'pie',
            data: {
                labels: labels, // Spécialités
                datasets: [{
                    data: data, // Nombre de médecins
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.6)',
                        'rgba(54, 162, 235, 0.6)',
                        'rgba(255, 206, 86, 0.6)',
                        'rgba(75, 192, 192, 0.6)',
                        'rgba(153, 102, 255, 0.6)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        display: true,
                        position: 'top'
                    },
                    title: {
                        display: true,
                        text: 'Répartition des médecins par spécialité'
                    }
                }
            }
        });
    </script>
			
		</main>
		<!-- MAIN -->
	</section>
	<!-- CONTENT -->
	

	<script src="template/script.js"></script>
</body>
</html>