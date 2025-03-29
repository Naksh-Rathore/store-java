public class Product {
    private final String name;
    private final String brand;

    private final int price;

    Product(String name, String brand, int price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return this.brand + " " + this.name + " ($" + this.price + ")";
    }

    public String getName() {
        return this.name;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getPrice() {
        return this.price;
    }
}
