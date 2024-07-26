

public class Booking {
    private User user;
    private Movie movie;
    private int numberOfTickets;

    public Booking(User user, Movie movie, int numberOfTickets) {
        this.user = user;
        this.movie = movie;
        this.numberOfTickets = numberOfTickets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "user=" + user.getUsername() +
                ", movie=" + movie.getTitle() +
                ", numberOfTickets=" + numberOfTickets +
                '}';
    }
}
