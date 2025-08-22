package dao;

import model.Book;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public void addBook(Book book) {
        String sql = "INSERT INTO books (titre, auteur, isbn, anneePublication, genre) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, book.getTitre());
            ps.setString(2, book.getAuteur());
            ps.setString(3, book.getIsbn());
            ps.setInt(4, book.getAnneePublication());
            ps.setString(5, book.getGenre());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitre(rs.getString("titre"));
                b.setAuteur(rs.getString("auteur"));
                b.setIsbn(rs.getString("isbn"));
                b.setAnneePublication(rs.getInt("anneePublication"));
                b.setGenre(rs.getString("genre"));
                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBook(Book book) {
        String sql = "UPDATE books SET titre=?, auteur=?, isbn=?, anneePublication=?, genre=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, book.getTitre());
            ps.setString(2, book.getAuteur());
            ps.setString(3, book.getIsbn());
            ps.setInt(4, book.getAnneePublication());
            ps.setString(5, book.getGenre());
            ps.setInt(6, book.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Book getBookByTitle(String titre) {
        String sql = "SELECT * FROM books WHERE titre LIKE ?";
        Book book = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + titre + "%");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitre(rs.getString("titre"));
                book.setAuteur(rs.getString("auteur"));
                book.setIsbn(rs.getString("isbn"));
                book.setAnneePublication(rs.getInt("anneePublication"));
                book.setGenre(rs.getString("genre"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }
    
 // Recherche par année
    public List<Book> getBooksByYear(int annee) {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE anneePublication=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, annee);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitre(rs.getString("titre"));
                book.setAuteur(rs.getString("auteur"));
                book.setIsbn(rs.getString("isbn"));
                book.setAnneePublication(rs.getInt("anneePublication"));
                book.setGenre(rs.getString("genre"));
                books.add(book);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

}
