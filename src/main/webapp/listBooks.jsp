<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, model.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Liste des Livres</title>
</head>
<body>
<h2>Liste des Livres</h2>
<a href="index.jsp">Accueil</a> | 
<a href="BookServlet?action=new">Ajouter un livre</a>
<br/><br/>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Titre</th>
        <th>Auteur</th>
        <th>ISBN</th>
        <th>Année</th>
        <th>Genre</th>
        <th>Actions</th>
    </tr>
    <%
        List<Book> listBooks = (List<Book>) request.getAttribute("listBooks");
        if (listBooks != null) {
            for (Book b : listBooks) {
    %>
    <tr>
        <td><%= b.getId() %></td>
        <td><%= b.getTitre() %></td>
        <td><%= b.getAuteur() %></td>
        <td><%= b.getIsbn() %></td>
        <td><%= b.getAnneePublication() %></td>
        <td><%= b.getGenre() %></td>
        <td>
            <a href="BookServlet?action=edit&id=<%= b.getId() %>">Modifier</a> |
            <a href="BookServlet?action=delete&id=<%= b.getId() %>">Supprimer</a>
        </td>
    </tr>
    <% } } %>
</table>
</body>
</html>
