
public class Motorcycle implements Item {
    private String bikePlate;
    private int year;
    private String make;


    public Motorcycle(String bikePlate, int year, String make) {
        this.bikePlate = bikePlate;
        this.year = year;
        this.make = make;
    
    }

    @Override
    public String getInfo() {
        return String.format("Motorcycle: %d  %s with license plate: %s", year, make, bikePlate);
    }
}