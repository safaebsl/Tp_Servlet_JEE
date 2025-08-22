<!DOCTYPE html>
<html>
<head>
    <title>Accueil</title>
</head>
<body>
    <h2>Gestion des Livres</h2>
    <a href="BookServlet?action=list">Lister les livres</a><br/>
    <a href="BookServlet?action=new">Ajouter un livre</a><br/>
    <form action="BookServlet" method="get">
        <input type="hidden" name="action" value="search"/>
        <input type="text" name="titre" placeholder="Rechercher par titre"/>
        <input type="submit" value="Rechercher"/>
    </form>
</body>
</html>
