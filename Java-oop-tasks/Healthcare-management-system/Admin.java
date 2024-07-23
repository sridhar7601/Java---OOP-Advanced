import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends Person {
    private List<User> users;

    public Admin(String username, String password) {
        super(username, password);
        users = new ArrayList<>();
    }

    @Override
    public void role() {
        System.out.println("Role: Admin");
    }

    @Override
    public void interact() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWelcome, Admin. Choose an option:");
            System.out.println("1. View Users");
            System.out.println("2. Add User");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewUsers();
                    break;
                case 2:
                    addUser(scanner);
                    break;
                case 3:
                    updateUser(scanner);
                    break;
                case 4:
                    deleteUser(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void viewUsers() {
        System.out.println("\nUser List:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    private void addUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter role: ");
        String role = scanner.nextLine();
        users.add(new User(username, role));
        System.out.println("User added successfully.");
    }

    private void updateUser(Scanner scanner) {
        System.out.print("Enter username to update: ");
        String username = scanner.nextLine();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.print("Enter new username: ");
                String newUsername = scanner.nextLine();
                System.out.print("Enter new role: ");
                String newRole = scanner.nextLine();
                user.setUsername(newUsername);
                user.setRole(newRole);
                System.out.println("User updated successfully.");
                return;
            }
        }
        System.out.println("User not found.");
    }

    private void deleteUser(Scanner scanner) {
        System.out.print("Enter username to delete: ");
        String username = scanner.nextLine();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                users.remove(user);
                System.out.println("User deleted successfully.");
                return;
            }
        }
        System.out.println("User not found.");
    }
}
