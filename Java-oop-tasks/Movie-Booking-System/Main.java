
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // private static final UserDAO userDAO = new UserDAO();
    // private static final ArrayList<Admin> admins = new ArrayList<>();
    private static final ArrayList<Movie> movies = new ArrayList<>();
    private static final ArrayList<Booking> bookings = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Adding a default admin and user for testing
        // admins.add(new Admin("admin", "admin123"));
        // users.add(new User("user", "user123"));

        while (true) {
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> adminLogin();
                case 2 -> userLogin();
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void login(String tableName) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        GenericDAO dao = new GenericDAO();
        Person person = dao.authenticate(tableName, username, password);
        
        if (person != null) {
            System.out.println("Login successful.");
            if (person instanceof User user) {
                userMenu(user);
            } else if (person instanceof Admin) {
                adminMenu();
            }
        } else {
            System.out.println("Invalid credentials.");
        }
    }
    
    // User Login
    private static void userLogin() {
        login("users"); // Passing "users" table name for user authentication
    }
    
    // Admin Login
    private static void adminLogin() {
        login("admins"); // Passing "admins" table name for admin authentication
    }
    
    // // Admin Login
    // private static void adminLogin() {
    //     System.out.print("Enter username: ");
    //     String username = scanner.nextLine();
    //     System.out.print("Enter password: ");
    //     String password = scanner.nextLine();

    //     for (Admin admin : admins) {
    //         if (admin.authenticate(username, password)) {
    //             System.out.println("Admin logged in successfully.");
    //             adminMenu();
    //             return;
    //         }
    //     }
    //     System.out.println("Invalid admin credentials.");
    // }

    // // User Login
    // private static void userLogin() {
    //     System.out.print("Enter username: ");
    //     String username = scanner.nextLine();
    //     System.out.print("Enter password: ");
    //     String password = scanner.nextLine();
    //     User user = userDAO.authenticate(username, password);
    //     if (user != null) {
    //         System.out.println(user.username);
    //         userMenu(user);
    //     } else {
    //         System.out.println("Invalid user credentials.");
    //     }
    // }


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
                case 1 -> manageMovies();
                case 2 -> viewBookings();
                case 3 -> {
                    System.out.println("Admin logged out.");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // User Menu
    private static void userMenu(User user) {
        while (true) {
            System.out.println("1. View Movies");
            System.out.println("2. Book Tickets");
            System.out.println("3. View My Bookings");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> viewMovies();
                case 2 -> bookTickets(user);
                case 3 -> viewMyBookings(user);
                case 4 -> {
                    System.out.println("User logged out.");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Manage Movies (Admin)
// Manage Movies (Admin)
private static void manageMovies() {
    while (true) {
        System.out.println("1. Add Movie");
        System.out.println("2. Edit Movie");
        System.out.println("3. Delete Movie");
        System.out.println("4. View Movies");
        System.out.println("5. Back to Admin Menu");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> addMovie();
            case 2 -> editMovie();
            case 3 -> deleteMovie();
            case 4 -> viewMovies();
            case 5 -> {
                return;
            }
            default -> System.out.println("Invalid choice. Try again.");
        }
    }
}

// Add Movie
private static void addMovie() {
    System.out.print("Enter title: ");
    String title = scanner.nextLine();
    System.out.print("Enter genre: ");
    String genre = scanner.nextLine();
    System.out.print("Enter duration (minutes): ");
    int duration = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    movies.add(new Movie(title, genre, duration));
    System.out.println("Movie added successfully.");
}

// Edit Movie
private static void editMovie() {
    System.out.print("Enter movie title to edit: ");
    String title = scanner.nextLine();
    Movie movie = findMovieByTitle(title);

    if (movie != null) {
        System.out.print("Enter new title (leave blank to keep current): ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new genre (leave blank to keep current): ");
        String newGenre = scanner.nextLine();
        System.out.print("Enter new duration (leave blank to keep current): ");
        String newDuration = scanner.nextLine();

        if (!newTitle.isBlank()) {
            movie.setTitle(newTitle);
        }
        if (!newGenre.isBlank()) {
            movie.setGenre(newGenre);
        }
        if (!newDuration.isBlank()) {
            movie.setDuration(Integer.parseInt(newDuration));
        }

        System.out.println("Movie updated successfully.");
    } else {
        System.out.println("Movie not found.");
    }
}

// Delete Movie
private static void deleteMovie() {
    System.out.print("Enter movie title to delete: ");
    String title = scanner.nextLine();
    Movie movie = findMovieByTitle(title);

    if (movie != null) {
        movies.remove(movie);
        System.out.println("Movie deleted successfully.");
    } else {
        System.out.println("Movie not found.");
    }
}

// View Movies
private static void viewMovies() {
    if (movies.isEmpty()) {
        System.out.println("No movies available.");
    } else {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}

// Find Movie by Title
private static Movie findMovieByTitle(String title) {
    for (Movie movie : movies) {
        if (movie.getTitle().equalsIgnoreCase(title)) {
            return movie;
        }
    }
    return null;
}

// View Bookings (Admin)
private static void viewBookings() {
    if (bookings.isEmpty()) {
        System.out.println("No bookings available.");
    } else {
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}

// Book Tickets (User)
private static void bookTickets(User user) {
    viewMovies();
    System.out.print("Enter movie title to book: ");
    String title = scanner.nextLine();
    Movie movie = findMovieByTitle(title);

    if (movie != null) {
        System.out.print("Enter number of tickets: ");
        int numberOfTickets = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        bookings.add(new Booking(user, movie, numberOfTickets));
        System.out.println("Tickets booked successfully.");
    } else {
        System.out.println("Movie not found.");
    }
}

// View My Bookings (User)
private static void viewMyBookings(User user) {
    boolean hasBookings = false;
    for (Booking booking : bookings) {
        if (booking.getUser().getUsername().equals(user.getUsername())) {
            System.out.println(booking);
            hasBookings = true;
        }
    }
    if (!hasBookings) {
        System.out.println("No bookings found for you.");
    }
}}
