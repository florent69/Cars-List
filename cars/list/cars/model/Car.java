package cars.list.cars.model;

import cars.list.cars.CarIndex;

import java.util.UUID;

public class Car {
    private int id = CarIndex.getIndex();
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
