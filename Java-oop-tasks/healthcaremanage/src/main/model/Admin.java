package main.model;

public class Admin extends Person {
    private int adminId;

    public Admin(int adminId,String username, String password) {
        super(username, password); // Call the constructor of Person
        this.adminId = adminId;
    }

    public int getAdminId() {
        return adminId;
    }
    public String getUser() {
        return username;
    }

    @Override
    public void role() {
        System.out.println("Admin Role");
    }

}
