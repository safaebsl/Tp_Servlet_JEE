package model;

public class Book {
    private int id;
    private String titre;
    private String auteur;
    private String isbn;
    private int anneePublication;
    private String genre;

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public int getAnneePublication() { return anneePublication; }
    public void setAnneePublication(int anneePublication) { this.anneePublication = anneePublication; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
}
