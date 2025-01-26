package org.example;

import java.util.Date;

// Transaction class
class Transaction {
    private String id;
    private User user;
    private Book book;
    private int quantity;
    private Date date;

    public Transaction(String id, User user, Book book, int quantity, Date date) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.quantity = quantity;
        this.date = date;
    }

    public String getTransactionID() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Transaction [ID=" + id + ", User=" + user.getName() + ", Book=" + book.getTitle() +
                ", Quantity=" + quantity + ", Date=" + date + "]";
    }
}