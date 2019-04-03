import java.io.Serializable;

public class Car implements Serializable {
    private String name;
    private String model;
    private int year;
    private int millage;

    public Car() {
        this.name = "";
        this.model = "";
        this.year = 0;
        this.millage = 0;
    }
    public Car(String name, String model, int year, int millage) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.millage = millage;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMillage() {
        return millage;
    }

    public void setMillage(int millage) {
        this.millage = millage;
    }



}
