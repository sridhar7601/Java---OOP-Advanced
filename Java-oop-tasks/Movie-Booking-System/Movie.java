public class Movie {
    private int movieId;
    private String title;
    private String genre;
    private int duration;
    private int adminId;

    public Movie(int movieId, String title, String genre, int duration, int adminId) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.adminId = adminId;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAdminId() {
        return adminId;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", adminId=" + adminId +
                '}';
    }
}
