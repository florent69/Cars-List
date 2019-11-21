package cars.list.cars.dao;

import cars.list.cars.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Car, Integer> {
    Car findById(int id);

}
