<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Résultats Recherche par Année</title>
</head>
<body>
    <h2>Résultats de la recherche</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Titre</th>
            <th>Auteur</th>
            <th>ISBN</th>
            <th>Année</th>
            <th>Genre</th>
        </tr>
        <c:forEach var="book" items="${listBooks}">
            <tr>
                <td>${book.id}</td>
                <td>${book.titre}</td>
                <td>${book.auteur}</td>
                <td>${book.isbn}</td>
                <td>${book.anneePublication}</td>
                <td>${book.genre}</td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="index.jsp">Retour</a>
</body>
</html>
