package cars.list.cars.controller;

import cars.list.cars.dao.ProductDao;
import cars.list.cars.model.Car;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api( "API pour les opérations CRUD sur les products (car).")
@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @ApiOperation(value = "Récupérer la liste des produits")
    @RequestMapping(value = {"/product"}, method = RequestMethod.GET)
    public @ResponseBody List<Car> ProductList() {
        return productDao.findAll();
    }


    @ApiOperation(value = "Récupère un produit grâce à son ID")
    @GetMapping(value="/product/{id}")
    public Car displayProduct(@PathVariable int id) {
        return productDao.findById(id);
    }

    @ApiOperation(value = "Ajoute un produit")
    @PostMapping(value="/product")
    public void addProduct(@RequestBody Car car){
        productDao.save(car);
    }

    @ApiOperation(value = "Modifie un produit")
    @PutMapping(value="/product")
    public Car updateProduct(@RequestBody Car carDetails) {
        Car car = productDao.findById(carDetails.getId());
        if(carDetails.getBrand() != null){
            car.setBrand(carDetails.getBrand());
        }
        if(carDetails.getName() != null) {
            car.setName(carDetails.getName());
        }
        return productDao.save(car);
    }

    @ApiOperation(value = "Supprime un produit")
    @DeleteMapping(value="/product/{id}")
    public void deleteProduct(@PathVariable int id) {
        Car car = displayProduct(id);
        productDao.delete(car);
    }

}
