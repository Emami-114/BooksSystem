package org.example;

public class Main {
    public static void main(String[] args) {
        try {
           Book book1 = new Book(6,"444","asss","1334256","category",13.34,4);
//           book1.addBookToDatabase(book1);
//           book1.getBooks();

//            dbHandler.addBookToDatabase(new Book(3,"first book","adam","1234","Cate",12.9,2));
//            dbHandler.updateBook(3,"drite book","assaa","13422","ca",33.0,2);

        } catch (Exception e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}