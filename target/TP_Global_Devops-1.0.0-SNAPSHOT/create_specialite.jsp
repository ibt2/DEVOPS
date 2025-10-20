<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Ajout d'une nouvelle Spécialité</h1>
<form action="Spec_servlet?action=add_spec" method="post">
        Nom: <input type="text" name="nom_form">
        <input type="submit" value="Créer">
</form>
</body>
</html>