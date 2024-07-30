import java.util.Scanner;

public class Patient extends Person {
    public Patient(String username, String password) {
        super(username, password);
    }

    @Override
    public void role() {
        System.out.println("Role: Patient");
    }

    @Override
    public void interact() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome, Patient.");
            System.out.println("Enter your symptoms:");
            String symptoms = scanner.nextLine();
            System.out.println("Symptoms recorded: " + symptoms);
        }
    }
}
