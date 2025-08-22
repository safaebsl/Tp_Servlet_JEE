<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.Book" %>
<!DOCTYPE html>
<html>
<head>
    <title>Recherche Livre</title>
</head>
<body>
<h2>Résultat de la recherche</h2>
<a href="index.jsp">Accueil</a>
<br/><br/>
<%
    Book book = (Book) request.getAttribute("book");
    if (book != null) {
%>
    <p><b>Titre:</b> <%= book.getTitre() %></p>
    <p><b>Auteur:</b> <%= book.getAuteur() %></p>
    <p><b>ISBN:</b> <%= book.getIsbn() %></p>
    <p><b>Année:</b> <%= book.getAnneePublication() %></p>
    <p><b>Genre:</b> <%= book.getGenre() %></p>
<% } else { %>
    <p>Aucun livre trouvé</p>
<% } %>
</body>
</html>
