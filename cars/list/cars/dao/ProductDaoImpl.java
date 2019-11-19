package cars.list.cars.dao;

import cars.list.cars.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    public static List<Car> products = new ArrayList<>();

    static {
        products.add(new Car("Tesla", "Model S"));
        products.add(new Car("Volkswagen", "ID"));

    }

    @Override
    public List<Car> findAll() {
        return products;
    }

    @Override
    public Car findById(int id) {
        for (Car car : products) {
            if(car.getId() == id){
                return car;
            }
        }
        return null;
    }

    @Override
    public Car save(Car car) {
        products.add(car);
        return car;
    }
}
