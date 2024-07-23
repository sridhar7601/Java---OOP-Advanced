public abstract class Person {
    protected String username;
    protected String password;

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public abstract void role();
    public abstract void interact();
}
