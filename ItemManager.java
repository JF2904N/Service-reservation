
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ItemManager {
    private List<Item> items;
    private List<Booking> bookings;
    private Scanner scanner;
    public String itemType;
    
    public ItemManager() {
        this.items = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.scanner = new Scanner(System.in);  
    }
    public Scanner getScanner() {
        return scanner;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
    


    public void listItems() {
        System.out.println("List of items:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + ". " + items.get(i).getInfo());
        }
    }
    public String getItemType() {
        return this.itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    
    public void createNewItem() {
    	 while (true) {
             System.out.println("Would you like to book a car, vacation or motorcycle (please type exactly what you want)");
             this.itemType = scanner.nextLine().toLowerCase();

             if ("car".equals(this.itemType) || "motorcycle".equals(this.itemType) || "vacation".equals(this.itemType)) {
                 break;
             } else {
                 System.out.println("Invalid item type. Please enter 'car', 'motorcycle', or 'vacation'.");
             }
         }

        ItemFactory itemFactory = createItemFactory();
        Item newItem = itemFactory.createItem();

        addItem(newItem);

        System.out.println("Booking successful!");
    }
    
    private ItemFactory createItemFactory() {
        switch (itemType) {
            case "car":
                return new CarFactory(scanner);
            case "motorcycle":
                return new MotorcycleFactory(scanner);
            case "vacation":
                return new VacationFactory(scanner);
            default:
                throw new IllegalArgumentException("Invalid item type");
        }
    }
}
        
   