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
	<title>Gestion RDV</title>
	<style>
	/* Form container styling */
	form {
		margin: 0 auto;
		width: 50%;
		background: #f8f9fa;
		padding: 20px;
		border-radius: 10px;
		box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
	}
	form label {
		font-size: 16px;
		color: #333;
		display: flex;
		align-items: center;
		margin-bottom: 10px;
	}
	form input, form select {
		width: 100%;
		padding: 10px;
		margin-bottom: 20px;
		border: 1px solid #ddd;
		border-radius: 5px;
		font-size: 14px;
	}
	form input[type="submit"] {
		background: #87CEEB; /* Bleu ciel */
		color: #fff;
		cursor: pointer;
		border: none;
		transition: background 0.3s;
		border-radius: 5px;
		padding: 10px 15px;
		font-size: 16px;
	}
	form input[type="submit"]:hover {
		background: #5ab7df; /* Couleur plus foncée au survol */
	}
	.icon {
		margin-right: 10px;
		color: #555;
	}
	h1 {
		text-align: center;
		color: #333;
		margin-bottom: 20px;
	}
</style>

</head>
<body>
	<section id="content">
		<!-- MAIN -->
		<main>
			<div class="head-title">
				<div class="left">
					<h1>Saisissez les infos du médecin</h1>
				</div>
			</div>
			
			<!-- Centered Form -->
			<form action="Medecin_servlet?action=form2" method="POST">
				<label for="nom">
					<i class='bx bx-user icon'></i>Nom :
				</label>
				<input type="text" id="nom" name="nom" placeholder="Entrez le nom" required>
				
				<label for="prenom">
					<i class='bx bx-user icon'></i>Prénom :
				</label>
				<input type="text" id="prenom" name="prenom" placeholder="Entrez le prénom" required>
				
				<label for="telephone">
					<i class='bx bx-phone icon'></i>Téléphone :
				</label>
				<input type="number" id="telephone" name="tel" placeholder="Entrez le numéro" required>
				
				<label for="choix">
					<i class='bx bx-folder-open icon'></i>Spécialité :
				</label>
				<select name="id_spec" id="choix" required>
					<c:forEach var="spec" items="${liste_spec}">
						<option value="${spec.id}">${spec.nom}</option>
					</c:forEach>
				</select>
				
				<input type="submit" value="Ajouter">
			</form>
		</main>
		<!-- MAIN -->
	</section>
</body>
</html>
