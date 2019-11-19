package cars.list.cars.model;

import java.util.UUID;

public class Product {
    private String id = UUID.randomUUID().toString();
    private String brand;
    private String name;

    public Product() {

    }

    public Product( String brand, String name) {
        this.brand = brand;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
