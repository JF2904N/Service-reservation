import java.util.List;
import java.util.Scanner;

public class Revenue {
    public double calculateRevenue(List<Booking> bookings, ItemManager itemManager) {
        double totalRevenue = 0.0;
        for (Booking booking : bookings) {
            int rentalDuration = booking.getRentalDuration();
            String itemType = itemManager.getItemType();
            double rate = getRateByItemType(itemType);
            double discountedRate = applyMembershipDiscount(itemManager, rate);

            totalRevenue += calculateRevenueForBooking(rentalDuration, discountedRate);
        }
        return totalRevenue;
    }

    private double calculateRevenueForBooking(int rentalDuration, double rate) {
        return rentalDuration * rate;
    }

    private double getRateByItemType(String itemType) {
        switch (itemType) {
            case "car":
                return 80.0;
            case "vacation":
                return 120.0;
            case "motorcycle":
                return 50.0;
            default:
                throw new IllegalArgumentException("Invalid item type");
        }
    }

    private double applyMembershipDiscount(ItemManager itemManager, double rate) {
        Scanner scanner = itemManager.getScanner();

        // Ask for membership type
        System.out.println("Do you have a membership? (Regular, Silver, Gold)");
        String membershipType = scanner.nextLine().toLowerCase();

        // Apply discount based on membership type
        switch (membershipType) {
            case "regular":
                return rate; // 0% discount
            case "silver":
                return rate * 0.9; // 10% discount
            case "gold":
                return rate * 0.8; // 20% discount
            default:
                System.out.println("Invalid membership type. No discount applied.");
                return rate;
        }
    }

}



