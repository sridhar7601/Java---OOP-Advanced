import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String adminUsername = "admin";
            String adminPassword = "admin123";
            String doctorUsername = "doctor";
            String doctorPassword = "doctor123";
            String patientUsername = "patient";
            String patientPassword = "patient123";
            
            System.out.print("Enter role (admin/doctor/patient): ");
            String role = scanner.nextLine();
            
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            
            Person person = null; //common interface for all types of person
            
            // authenticate based on role
            if (role.equalsIgnoreCase("admin")) {
                person = new Admin(adminUsername, adminPassword);
            } else if (role.equalsIgnoreCase("doctor")) {
                person = new Doctor(doctorUsername, doctorPassword);
            } else if (role.equalsIgnoreCase("patient")) {
                person = new Patient(patientUsername, patientPassword);
            }
            
            if (person != null && person.authenticate(username, password)) {
                person.role();
                person.interact();
            } else {
                System.out.println("Invalid credentials or role");
            }
        }
    }
}
