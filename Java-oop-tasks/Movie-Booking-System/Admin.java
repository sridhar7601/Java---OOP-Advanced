public class Admin extends User implements IMovieManager {
    public Admin(String username, String password) {
        super(username, password, "admin");
    }

    @Override
    public void role() {
        System.out.println("Role: Admin");
    }

    @Override
    public void interact() {
        System.out.println("Admin interaction.");
    }

    @Override
    public void addMovie(Movie movie) {
    }

    @Override
    public void removeMovie(String title) {
    }

    @Override
    public void listMovies() {
    }
}
