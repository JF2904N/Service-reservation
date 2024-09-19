import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ItemManager itemManager = new ItemManager();
        List<Booking> bookings = new ArrayList<>();
        Booking booking = new Booking(new ArrayList<>());
        Revenue revenueCalculator = new Revenue();
        System.out.println("Hello, welcome to our Reservation application. Please choose a service:");

        boolean exitProgram = false;

        while (!exitProgram) {
            String bookNewItemChoice;

           
            while (true) {
                System.out.println("Would you like to book a new item? (Enter 'yes' or 'no')");
                bookNewItemChoice = scanner.nextLine();

                if (bookNewItemChoice.equalsIgnoreCase("yes") || bookNewItemChoice.equalsIgnoreCase("no")) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
                }
            }

            if (bookNewItemChoice.equalsIgnoreCase("yes")) {
                // Call the setRentalPeriod method on the Booking instance
                booking.setRentalPeriod(scanner);

                // After setting the rental period, create a new item
                itemManager.createNewItem();

                // Add the booking to the list of bookings
                bookings.add(booking);
            } else if (bookNewItemChoice.equalsIgnoreCase("no")) {
                System.out.println("Exiting the program. Goodbye!");
                exitProgram = true;
            }

            if (!exitProgram) {
                while (true) {
                    System.out.println("Is there anything else you want to look at before you go?");
                    System.out.println("1. List Items");
                    System.out.println("2. List Bookings");
                    System.out.println("3. Revenue");
                    System.out.println("4. Book a new item");
                    System.out.println("5. Exit");

                    int userChoice;
                    // Loop until a valid input is provided
                    while (true) {
                        if (scanner.hasNextInt()) {
                            userChoice = scanner.nextInt();
                            scanner.nextLine();  // Consume the newline character
                            break;
                        } else {
                            System.out.println("Invalid choice. Please enter a number.");
                            scanner.nextLine();  // Consume the invalid input
                        }
                    }

                    switch (userChoice) {
                        case 1:
                            // List items
                            itemManager.listItems();
                            break;
                        case 2:
                            // List bookings
                            booking.listBookings(bookings);
                            break;
                        case 3:
                            double totalRevenue = revenueCalculator.calculateRevenue(bookings, itemManager);
                            System.out.println("Total Revenue: $" + totalRevenue);
                            break;
                        case 4:
                            // Book a new item
                            while (true) {
                                System.out.println("Would you like to book a new item? (Enter 'yes' or 'no')");
                                bookNewItemChoice = scanner.nextLine();

                                if (bookNewItemChoice.equalsIgnoreCase("yes") || bookNewItemChoice.equalsIgnoreCase("no")) {
                                    break;
                                } else {
                                    System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
                                }
                            }

                            if (bookNewItemChoice.equalsIgnoreCase("yes")) {
                                // Create a new Booking instance
                                booking = new Booking(new ArrayList<>());

                                // Call the setRentalPeriod method on the new Booking instance
                                booking.setRentalPeriod(scanner);

                                // After setting the rental period, create a new item
                                itemManager.createNewItem();

                                // Add the new booking to the list of bookings
                                bookings.add(booking);
                            } else if (bookNewItemChoice.equalsIgnoreCase("no")) {
                                System.out.println("Exiting the program. Goodbye!");
                                exitProgram = true;
                            }
                            break;
                        case 5:
                            System.out.println("Exiting the program. Goodbye!");
                            exitProgram = true;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }

                    if (exitProgram || userChoice == 5) {
                        break;  // Exit the inner loop if the user chooses to exit
                    }
                }
            }
        }
    }
}
