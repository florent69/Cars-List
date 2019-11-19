package cars.list.cars.dao;

import cars.list.cars.model.Car;

import java.util.List;

public interface ProductDao {
    public List<Car> findAll();
    public Car findById(int id);
    public Car save(Car car);
}
