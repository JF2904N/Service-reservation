
public class Vacation implements Item {
    private String country;
    private String city;
    private String season;

    public Vacation(String country, String city, String season) {
        this.country = country;
        this.city = city;
        this.season = season;
    }

    @Override
    public String getInfo() {
        return String.format("Vacation: %s, %s, %s", country, city, season);
    }
}