<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
</head>
<body>
<h3> Voici une liste de vos rendez vous</h3>

<table>
<tr>
	<th>Medecin</th>
	<th>Jour</th>
	<th>Heure debut</th>
	<th>Heure fin</th>
</tr>
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
</table>
</body>
</html>