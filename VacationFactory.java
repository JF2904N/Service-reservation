import java.util.Scanner;

public class VacationFactory implements ItemFactory {
    private final Scanner scanner;

    public VacationFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Item createItem() {
        String country = "";
        String city = "";
        String season = "";

        while (true) {
            System.out.println("What country do you want to go? (options are America, Japan, Germany): ");
            country = scanner.nextLine();

            if ("America".equalsIgnoreCase(country) || "Japan".equalsIgnoreCase(country) || "Germany".equalsIgnoreCase(country)) {
                if (country.equalsIgnoreCase("America")) {
                    while (true) {
                        System.out.println("What city in America do you want to go? (options are Denver, Boston, LA): ");
                        city = scanner.nextLine();
                        if ("Denver".equalsIgnoreCase(city) || "Boston".equalsIgnoreCase(city) || "LA".equalsIgnoreCase(city)) {
                            break; // Break the inner loop if the input is valid
                        } else {
                            System.out.println("Invalid input. Please enter a valid city in America.");
                        }
                    }
                } else if (country.equalsIgnoreCase("Japan")) {
                    while (true) {
                        System.out.println("What city in Japan do you want to go? (options are Tokyo, Osaka, Kyoto): ");
                        city = scanner.nextLine();
                        if ("Tokyo".equalsIgnoreCase(city) || "Osaka".equalsIgnoreCase(city) || "Kyoto".equalsIgnoreCase(city)) {
                            break; // Break the inner loop if the input is valid
                        } else {
                            System.out.println("Invalid input. Please enter a valid city in Japan.");
                        }
                    }
                } else if (country.equalsIgnoreCase("Germany")) {
                    while (true) {
                        System.out.println("What city in Germany do you want to go? (options are Frankfurt, Hamburg, Munich): ");
                        city = scanner.nextLine();
                        if ("Frankfurt".equalsIgnoreCase(city) || "Hamburg".equalsIgnoreCase(city) || "Munich".equalsIgnoreCase(city)) {
                            break; // Break the inner loop if the input is valid
                        } else {
                            System.out.println("Invalid input. Please enter a valid city in Germany.");
                        }
                    }
                }

                while (true) {
                    System.out.println("In what season do you want to go to " + city + "? (options are Spring, Summer, Fall, Winter): ");
                    season = scanner.nextLine();

                    // Validate the season input
                    if (season.equalsIgnoreCase("Spring") || season.equalsIgnoreCase("Summer") ||
                            season.equalsIgnoreCase("Fall") || season.equalsIgnoreCase("Winter")) {
                        // Valid input, break out of the loop
                        System.out.println("Vacation Information:");
                        System.out.println("Country: " + country + " city of " + city);
                        System.out.println("Season: " + season);
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a valid season.");
                    }
                }

                // Explicitly return a new Vacation instance
                return new Vacation(country, city, season);
            } else {
                System.out.println("Invalid input. Please enter a valid country.");
            }
        }
    }
}


