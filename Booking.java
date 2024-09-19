import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Booking {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd");

    private int bookingId;
    private Date fromDate;
    private Date toDate;
    private List<Item> items;
    private int rentalDuration;
    
    public Booking(List<Item> items) {
        this.items = items;
        this.bookingId = generateRandomBookingId();
    }

    private int generateRandomBookingId() {
        Random random = new Random();
        return random.nextInt(90000) + 10000;
    }

    public int getBookingId() {
        return bookingId;
    }

    public List<Item> getItems() {
        return items;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }
    public void listBookings(List<Booking> bookings) {
        System.out.println("List of Bookings:");
        for (Booking booking : bookings) {
            System.out.println("Booking ID: " + booking.getBookingId() +
                    ", From: " + booking.getFromDate() +
                    ", To: " + booking.getToDate());
        }
    }

    public void setRentalPeriod(Scanner scanner) {
        boolean validStart = false;
        boolean validEnd = false;

        while (!(validStart && validEnd)) {
            try {
                if (!validStart) {
                    System.out.println("Enter the start date in which you would like to book (e.g., September 15): ");
                    String startDateString = scanner.nextLine();
                    this.fromDate = new Date(dateFormat.parse(startDateString).getTime());
                    validStart = true;
                }

                if (!validEnd) {
                    System.out.println("Enter the end date in which you would like to book: ");
                    String endDateString = scanner.nextLine();
                    Date endDate = new Date(dateFormat.parse(endDateString).getTime());

                    // Calculate rental duration based on entered dates
                    long rentalDurationMillis = endDate.getTime() - this.fromDate.getTime();
                    this.rentalDuration = (int) (rentalDurationMillis / (24 * 60 * 60 * 1000)) + 1;

                    // Check if rental duration is positive
                    if (rentalDuration > 0) {
                        // Set the toDate based on the entered end date
                        this.toDate = endDate;
                        validEnd = true;
                    } else {
                        System.out.println("Invalid rental duration. Please enter a valid end date.");
                    }
                }
            } catch (ParseException e) {
                System.out.println("Wrong input. Please enter the date in the format 'Month day'.");
            }
        }
    }

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}


}
