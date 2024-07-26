
public class User extends Person {
    public User(String username, String password) {
        super(username, password); // Call the constructor of Person
    }

    @Override
    public void role() {
        System.out.println("User Role");
    }
}
