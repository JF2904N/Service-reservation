import java.util.Scanner;

public class CarFactory implements ItemFactory {
    private Scanner scanner;

    public CarFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Item createItem() {
        String licensePlate;
        int year;
        String make;
        int numberOfDoors;

        while (true) {
            System.out.print("Enter license plate (must be 6 digits): ");
            licensePlate = scanner.nextLine();

            if (licensePlate.length() == 6 && licensePlate.matches("\\d+")) {
                break;
            } else {
                System.out.println("Invalid license plate. Please enter 6 digits. Try again.");
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
            System.out.print("Enter make (we offer Mercedes, BMW, or Porsche): ");
            make = scanner.nextLine().toLowerCase();

            if (make.equals("mercedes") || make.equals("bmw") || make.equals("porsche")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid make.");
            }
        }

        while (true) {
            System.out.print("Enter number of doors (2 or 4): ");
            if (scanner.hasNextInt()) {
                numberOfDoors = scanner.nextInt();
                scanner.nextLine();

                if (numberOfDoors == 2 || numberOfDoors == 4) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 2 or 4.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number of doors.");
                scanner.nextLine();
            }
        }

        return new Car(licensePlate, year, make, numberOfDoors);
    }
}
