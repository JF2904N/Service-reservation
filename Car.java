
public class Car implements Item {
    private String licensePlate;
    private int year;
    private String make;
    private int numberOfDoors;

    public Car(String licensePlate, int year, String make, int numberOfDoors) {
        this.licensePlate = licensePlate;
        this.year = year;
        this.make = make;
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String getInfo() {
        return String.format("Car: %d %d door %s with license plate: %s", year, numberOfDoors, make, licensePlate);
    }
}
