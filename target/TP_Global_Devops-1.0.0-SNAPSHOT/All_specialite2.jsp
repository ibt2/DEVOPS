<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Quelle spécialité souhaitez vous?</h1>
<table border ="1">
<tr>
<th>Spécialité</th>
</tr>
<c:forEach var="spe" items="${liste_spe}" >
<tr>
<td><a href = "Disp_servlet?id_spec=${spe.id}&action=list_disp" > ${spe.nom} </a></td>
</tr>
</c:forEach>
</table>
</body>
</html>