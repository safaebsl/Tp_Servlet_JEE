<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un Livre</title>
</head>
<body>
    <h2>Ajouter un nouveau livre</h2>
    <form action="BookServlet" method="post">
        <input type="hidden" name="action" value="insert"/>
        Titre: <input type="text" name="titre"/><br/>
        Auteur: <input type="text" name="auteur"/><br/>
        ISBN: <input type="text" name="isbn"/><br/>
        Année: <input type="number" name="annee"/><br/>
        Genre: <input type="text" name="genre"/><br/>
        <input type="submit" value="Enregistrer"/>
    </form>
    <a href="index.jsp">Retour</a>
</body>
</html>
