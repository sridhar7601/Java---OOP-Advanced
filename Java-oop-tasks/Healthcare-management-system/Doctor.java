import java.util.Scanner;

public class Doctor extends Person {
    public Doctor(String username, String password) {
        super(username, password);
    }

    @Override
    public void role() {
        System.out.println("Role: Doctor");
    }

    @Override
    public void interact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, Doctor.");
        System.out.println("Enter patient diagnosis details:");
        String diagnosis = scanner.nextLine();
        System.out.println("Diagnosis recorded: " + diagnosis);
    }
}
