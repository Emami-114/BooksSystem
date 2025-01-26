package org.example;

public class Admin extends User {
    public Admin(int userID, String name, String email) {
        super(userID, name, email, RoleEnum.ADMIN);
    }

    @Override
    public void viewDetails() {
        super.viewDetails();
        System.out.println("Additional permissions: Full access");
    }
}
