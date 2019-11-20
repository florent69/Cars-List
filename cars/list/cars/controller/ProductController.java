package cars.list.cars.controller;

import cars.list.cars.dao.ProductDao;
import cars.list.cars.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    //Récupérer la liste des produits
    @RequestMapping(value = {"/product"}, method = RequestMethod.GET)
    public List<Car> ProductList() {
        return productDao.findAll();
    }

    //Récupérer un produit par son Id
    @GetMapping(value="/product/{id}")
    public Car displayProduct(@PathVariable int id) {
        return productDao.findById(id);
    }

    @PostMapping(value="/product")
    public void addProduct(@RequestBody Car car){
        productDao.save(car);
    }

    @PutMapping(value="/product")
    public Car updateCar(@RequestBody Car carDetails) {
        Car car = productDao.findById(carDetails.getId());
        if(carDetails.getBrand() != null){
            car.setBrand(carDetails.getBrand());
        }
        if(carDetails.getName() != null) {
            car.setName(carDetails.getName());
        }
        return car;
    }

    @DeleteMapping(value="/product/{id}")
    public void deleteCar(@PathVariable int id) {
        productDao.delete(id);
    }
}
