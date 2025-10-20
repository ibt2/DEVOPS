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
<c:forEach var="med" items = "${lst_med}">
<table>
<tr>
	<th colspan = "4">${med.nom} ${med.prenom}</th>
</tr>
<tr>
	<th>Jour</th>
	<th>Heure début</th>
	<th>Heure fin</th>
	<th>Action</th>
</tr>
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

</table>
<br>
<br>
 </c:forEach>
</body>
</html>