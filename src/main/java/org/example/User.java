package org.example;

public class User {
    private int id;
    private String name;
    private String email;
    private RoleEnum role;

    public User(int id, String name, String email, RoleEnum role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public int getUserID() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void viewDetails() {
        System.out.println("User ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Role: " + role);
    }

    public enum RoleEnum {
        ADMIN,
        Customer
    }
}
