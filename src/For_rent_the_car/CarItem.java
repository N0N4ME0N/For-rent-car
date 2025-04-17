package For_rent_the_car;

public class CarItem {
    private final String brand;
    private final String model;
    public CarItem(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    public String getBrand() { 
        return brand; }
    
    public String getModel() { 
        return model; }
    
    @Override
    public String toString() {
        return brand + " " + model;
    }

}
