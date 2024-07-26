
import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    userLogin();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Admin Login
    private static void adminLogin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authenticate(username, password, "admin")) {
            System.out.println("Admin logged in successfully.");
            adminMenu();
        } else {
            System.out.println("Invalid admin credentials.");
        }
    }

    // User Login
    private static void userLogin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authenticate(username, password, "user")) {
            System.out.println("User logged in successfully.");
            userMenu(username);
        } else {
            System.out.println("Invalid user credentials.");
        }
    }

    // Authenticate User
    private static boolean authenticate(String username, String password, String role) {
        try (Connection connection = Database.getInstance().getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ? AND role = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, role);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Admin Menu
    private static void adminMenu() {
        while (true) {
            System.out.println("1. Manage Movies");
            System.out.println("2. View Bookings");
            System.out.println("3. Logout");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageMovies();
                    break;
                case 2:
                    viewBookings();
                    break;
                case 3:
                    System.out.println("Admin logged out.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // User Menu
    private static void userMenu(String username) {
        while (true) {
            System.out.println("1. View Movies");
            System.out.println("2. Book Tickets");
            System.out.println("3. View My Bookings");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewMovies();
                    break;
                case 2:
                    bookTickets(username);
                    break;
                case 3:
                    viewMyBookings(username);
                    break;
                case 4:
                    System.out.println("User logged out.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Manage Movies (Admin)
    private static void manageMovies() {
        while (true) {
            System.out.println("1. Add Movie");
            System.out.println("2. Update Movie");
            System.out.println("3. Delete Movie");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    updateMovie();
                    break;
                case 3:
                    deleteMovie();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Add Movie
    private static void addMovie() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter duration: ");
        int duration = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try (Connection connection = Database.getInstance().getConnection()) {
            String query = "INSERT INTO movies (title, genre, duration) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, title);
            statement.setString(2, genre);
            statement.setInt(3, duration);
            statement.executeUpdate();

            System.out.println("Movie added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Movie
    private static void updateMovie() {
        System.out.print("Enter movie ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter new duration: ");
        int duration = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try (Connection connection = Database.getInstance().getConnection()) {
            String query = "UPDATE movies SET title = ?, genre = ?, duration = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, title);
            statement.setString(2, genre);
            statement.setInt(3, duration);
            statement.setInt(4, id);
            statement.executeUpdate();

            System.out.println("Movie updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Movie
    private static void deleteMovie() {
        System.out.print("Enter movie ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try (Connection connection = Database.getInstance().getConnection()) {
            String query = "DELETE FROM movies WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();

            System.out.println("Movie deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View Movies
    private static void viewMovies() {
        try (Connection connection = Database.getInstance().getConnection()) {
            String query = "SELECT * FROM movies";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("Movies:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Title: " + resultSet.getString("title"));
                System.out.println("Genre: " + resultSet.getString("genre"));
                System.out.println("Duration: " + resultSet.getInt("duration") + " minutes");
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Book Tickets (User)
    private static void bookTickets(String username) {
        System.out.print("Enter movie ID to book: ");
        int movieId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter number of tickets: ");
        int numberOfTickets = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try (Connection connection = Database.getInstance().getConnection()) {
            // Get user ID
            String userQuery = "SELECT id FROM users WHERE username = ?";
            PreparedStatement userStatement = connection.prepareStatement(userQuery);
            userStatement.setString(1, username);
            ResultSet userResultSet = userStatement.executeQuery();
            int userId = 0;
            if (userResultSet.next()) {
                userId = userResultSet.getInt("id");
            }

            String query = "INSERT INTO bookings (user_id, movie_id, number_of_tickets) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            statement.setInt(2, movieId);
            statement.setInt(3, numberOfTickets);
            statement.executeUpdate();

            System.out.println("Tickets booked successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View Bookings (Admin)
    private static void viewBookings() {
        try (Connection connection = Database.getInstance().getConnection()) {
            String query = "SELECT * FROM bookings";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("Bookings:");
            while (resultSet.next()) {
                System.out.println("Booking ID: " + resultSet.getInt("id"));
                System.out.println("User ID: " + resultSet.getInt("user_id"));
                System.out.println("Movie ID: " + resultSet.getInt("movie_id"));
                System.out.println("Number of Tickets: " + resultSet.getInt("number_of_tickets"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View My Bookings (User)
    private static void viewMyBookings(String username) {
        try (Connection connection = Database.getInstance().getConnection()) {
            // Get user ID
            String userQuery = "SELECT id FROM users WHERE username = ?";
            PreparedStatement userStatement = connection.prepareStatement(userQuery);
            userStatement.setString(1, username);
            ResultSet userResultSet = userStatement.executeQuery();
            int userId = 0;
            if (userResultSet.next()) {
                userId = userResultSet.getInt("id");
            }

            String query = "SELECT * FROM bookings WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("My Bookings:");
            while (resultSet.next()) {
                System.out.println("Booking ID: " + resultSet.getInt("id"));
                System.out.println("Movie ID: " + resultSet.getInt("movie_id"));
                System.out.println("Number of Tickets: " + resultSet.getInt("number_of_tickets"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
