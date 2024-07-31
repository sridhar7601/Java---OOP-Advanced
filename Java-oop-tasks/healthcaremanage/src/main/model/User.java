package main.model;


public class User extends Person {
    // private int username;

    public User(String username, String password) {
        super(username, password); // Call the constructor of Person
        // this.userId = userId;

    }

    @Override
    public void role() {
        System.out.println("User Role");
    }
    @Override
    public String toString() {
        return "User{" +
                "username='" + getUsername() + '\'' +
                '}';
    }

}
