
public class Admin extends Person {
    public Admin(String username, String password) {
        super(username, password); // Call the constructor of Person
    }
    public String getUser() {
        return username;
    }

    @Override
    public void role() {
        System.out.println("Admin Role");
    }

    int getAdminId() {
        return 
    }


}
 