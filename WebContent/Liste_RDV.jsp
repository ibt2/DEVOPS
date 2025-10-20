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
    <style>
        /* Inline CSS for centering the table */
        .table-data .order {
            display: flex;
            justify-content: center; /* Center horizontally */
            align-items: center;    /* Center vertically if needed */
            min-height: 50vh;       /* Adjust height as needed */
        }

        .table-data table {
            width: auto; /* Adjust table width to content */
            border-collapse: collapse; /* Optional: improve border rendering */
            text-align: center; /* Center text in table */
        }

        .table-data td, .table-data th {
            text-align: center; /* Center content in table cells */
            padding: 10px;      /* Add padding for better readability */
            border: 1px solid #ddd; /* Optional: add border for clarity */
        }

        .table-data th {
            background-color: #f4f4f4; /* Optional: header background color */
        }

        a {
            text-decoration: none;
            color: #333;
        }

        a:hover {
            color: #007bff;
        }
    </style>
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
            <li>
                <a href="Login?action=Accueil_admin">
                    <i class='bx bxs-dashboard'></i>
                    <span class="text">Accueil</span>
                </a>
            </li>
            <li>
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
            <li class="active">
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
            <i class='bx bx-menu'></i>
            <a href="#" class="logout">
                <i class='bx bxs-log-out-circle'></i>
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
                    <h1>Sélectionnez un médécin!!</h1>
                </div>
            </div>
            
            <div class="table-data">
                <div class="order">
                    <table>
                        <thead>
                            <tr>
                                <th>Médécins</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="med" items="${liste_med}">
                                <tr>
                                    <td>
                                        <a href="RDV_servlet?action=rdvMed2&id_med=${med.id}">
                                            ${med.nom} ${med.prenom}
                                        </a>
                                    </td>
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
