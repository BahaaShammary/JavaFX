import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private String model;
    private double price;


    public Product() {
        this.name = "";
        this.model = "";
        this.price = 0;
    }

    public Product(String name, String model, double price) {
        this.name = name;
        this.model = model;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
