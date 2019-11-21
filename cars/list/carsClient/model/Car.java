package cars.list.carsClient.model;

import cars.list.carsClient.ClientIndex;

public class Car {
    private int id = ClientIndex.getIndex();
    private String brand;
    private String name;

    public Car() {

    }

    public Car(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
