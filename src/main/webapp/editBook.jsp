<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.Book" %>
<!DOCTYPE html>
<html>
<head>
    <title>Modifier Livre</title>
</head>
<body>
    <h2>Modifier Livre</h2>
    <%
        Book book = (Book) request.getAttribute("book");
        if (book != null) {
    %>
    <form action="BookServlet" method="post">
        <input type="hidden" name="action" value="update"/>
        <input type="hidden" name="id" value="<%= book.getId() %>"/>
        Titre: <input type="text" name="titre" value="<%= book.getTitre() %>"/><br/>
        Auteur: <input type="text" name="auteur" value="<%= book.getAuteur() %>"/><br/>
        ISBN: <input type="text" name="isbn" value="<%= book.getIsbn() %>"/><br/>
        Année: <input type="number" name="annee" value="<%= book.getAnneePublication() %>"/><br/>
        Genre: <input type="text" name="genre" value="<%= book.getGenre() %>"/><br/>
        <input type="submit" value="Modifier"/>
    </form>
    <% } %>
    <a href="index.jsp">Retour</a>
</body>
</html>
