import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    
    // Add a new movie to the database
    public void addMovie(Movie movie) {
        String sql = "INSERT INTO movies (title, genre, duration, admin_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, movie.getTitle());
            pstmt.setString(2, movie.getGenre());
            pstmt.setInt(3, movie.getDuration());
            pstmt.setInt(4, movie.getAdminId());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // List all movies from the database
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movies";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                int movieId = rs.getInt("movie_id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                int duration = rs.getInt("duration");
                int adminId = rs.getInt("admin_id");
                
                movies.add(new Movie(movieId, title, genre, duration, adminId));
            }
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return movies;
    }
}
