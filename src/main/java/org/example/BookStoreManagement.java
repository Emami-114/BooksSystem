package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookStoreManagement {
    private static final DatabaseHandler dbHandler = new DatabaseHandler();

    public static void addBookToDatabase(Book book) throws SQLException {
        String query = "INSERT INTO books (id,title, author, isbn, category, price, stock) VALUES (?,?, ?, ?, ?, ?, ?)";
        try (Connection conn = dbHandler.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, book.getId());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setString(4, book.getISBN());
            stmt.setString(5, book.getCategory());
            stmt.setDouble(6, book.getPrice());
            stmt.setInt(7, book.getStock());
            stmt.executeUpdate();
            System.out.println("Successfully added BOOK in postgres");
        } catch (Exception e) {
            System.err.println("Error while added BOOK to Postgres" + e.getMessage());
            throw e;
        }
    }

    public static void getBooks() {
        String sql = "SELECT * FROM books";
        try (Connection conn = dbHandler.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("Book in der Database: ");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", title: " + rs.getString("title") +
                        ", Author: " + rs.getString("author") + ", ISBN: " + rs.getString("isbn") +
                        ", Category: " + rs.getString("category") + ", Price: " + rs.getDouble("price") +
                        ", Stock: " + rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.err.println("Error get Books from DB " + e.getMessage());
        }
    }

    public static void updateBook(int id, String title, String author, String isbn, String category, double price, int stock) {
        String sql = "UPDATE books SET title = ?, author = ?, isbn = ?, category = ?, price = ?, stock = ? WHERE id = ?";
        try (Connection conn = dbHandler.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setString(3, isbn);
            stmt.setString(4, category);
            stmt.setDouble(5, price);
            stmt.setInt(6, stock);
            stmt.setInt(7, id);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Book successfully updated!");
            } else {
                System.out.println("No book found with the specified ID.");
            }
        } catch (SQLException e) {
            System.err.println("Error while update Book: " + e.getMessage());
        }
    }

    public static void searchBooks(String keyword) {
        String sql = "SELECT * FROM books WHERE title ILIKE ? OR author ILIKE ? OR category ILIKE ?";
        try (Connection conn = dbHandler.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            stmt.setString(3, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Category: " + rs.getString("category"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("Stock: " + rs.getInt("stock"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            System.err.println("Failed to search books: " + e.getMessage());
        }
    }

    public static void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = dbHandler.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("No book found with the specified ID.");
            }
        } catch (SQLException e) {
            System.err.println("Error while delete Book: " + e.getMessage());
        }
    }
}
