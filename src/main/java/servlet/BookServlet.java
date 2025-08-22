package servlet;

import dao.BookDAO;
import model.Book;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookDAO bookDAO;

    public void init() {
        bookDAO = new BookDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        try {
            switch (action) {
                case "new": showNewForm(request, response); break;
                case "insert": insertBook(request, response); break;
                case "delete": deleteBook(request, response); break;
                case "edit": showEditForm(request, response); break;
                case "update": updateBook(request, response); break;
                case "search": searchBook(request, response); break;
                case "searchByYear":searchBookByYear(request, response); break;
                default: listBooks(request, response); break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void searchBookByYear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int annee = Integer.parseInt(request.getParameter("annee"));
            List<Book> books = bookDAO.getBooksByYear(annee);
            request.setAttribute("listBooks", books);
            RequestDispatcher dispatcher = request.getRequestDispatcher("searchBookByYear.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Année invalide");
        }
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Book> listBooks = bookDAO.getAllBooks();
        request.setAttribute("listBooks", listBooks);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listBooks.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addBook.jsp");
        dispatcher.forward(request, response);
    }

    private void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        String isbn = request.getParameter("isbn");
        int annee = Integer.parseInt(request.getParameter("annee"));
        String genre = request.getParameter("genre");

        Book newBook = new Book();
        newBook.setTitre(titre);
        newBook.setAuteur(auteur);
        newBook.setIsbn(isbn);
        newBook.setAnneePublication(annee);
        newBook.setGenre(genre);

        bookDAO.addBook(newBook);
        response.sendRedirect("BookServlet?action=list");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookDAO.deleteBook(id);
        response.sendRedirect("BookServlet?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book existingBook = bookDAO.getAllBooks()
                                   .stream()
                                   .filter(b -> b.getId() == id)
                                   .findFirst()
                                   .orElse(null);
        request.setAttribute("book", existingBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editBook.jsp");
        dispatcher.forward(request, response);
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        String isbn = request.getParameter("isbn");
        int annee = Integer.parseInt(request.getParameter("annee"));
        String genre = request.getParameter("genre");

        Book book = new Book();
        book.setId(id);
        book.setTitre(titre);
        book.setAuteur(auteur);
        book.setIsbn(isbn);
        book.setAnneePublication(annee);
        book.setGenre(genre);

        bookDAO.updateBook(book);
        response.sendRedirect("BookServlet?action=list");
    }

    private void searchBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titre = request.getParameter("titre");
        Book book = bookDAO.getBookByTitle(titre);
        request.setAttribute("book", book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("searchBook.jsp");
        dispatcher.forward(request, response);
    }
}
