import java.util.Scanner;

public class MotorcycleFactory implements ItemFactory {
    private Scanner scanner;

    public MotorcycleFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Item createItem() {
        String licensePlate;
        int year;
        String make;

        while (true) {
            System.out.print("Enter license plate (must be 4 digits): ");
            licensePlate = scanner.nextLine();

            if (licensePlate.length() == 4 && licensePlate.matches("\\d+")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid 4-digit license plate.");
            }
        }

        while (true) {
            System.out.print("Enter year (between 1990 and 2023): ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                scanner.nextLine();

                if (year >= 1990 && year <= 2023) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid year.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid year.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        while (true) {
            System.out.print("Enter make (we offer brands like Yamaha, Honda, Ducati): ");
            make = scanner.nextLine().toLowerCase();

            if (make.equals("yamaha") || make.equals("honda") || make.equals("ducati")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid make.");
            }
        }

        return new Motorcycle(licensePlate, year, make);
    }
}
