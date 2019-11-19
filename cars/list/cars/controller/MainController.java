package cars.list.cars.controller;

import java.util.ArrayList;
import java.util.List;

import cars.list.cars.form.CarForm;
import cars.list.cars.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {


    @Autowired
    private static List<Car> cars = new ArrayList<Car>();

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    // index
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    //productList
    @RequestMapping(value = { "/carList" }, method = RequestMethod.GET)
    public String productList(Model model) {

        model.addAttribute("cars", cars);

        return "carList";
    }

    //addProduct GET
    @RequestMapping(value = { "/addCar" }, method = RequestMethod.GET)
    public String showAddProductPage(Model model) {

        CarForm carForm = new CarForm();
        model.addAttribute("carForm", carForm);

        return "addCar";
    }

    //addProduct POST
    @RequestMapping(value = { "/addCar" }, method = RequestMethod.POST)
    public String saveProduct(Model model, //
                             @ModelAttribute("carForm") CarForm carForm) {

        String brand = carForm.getBrand();
        String name = carForm.getName();

        if (brand != null && brand.length() > 0 //
                && name != null && name.length() > 0) {
            Car newCar = new Car(brand, name);
            cars.add(newCar);

            return "redirect:/carList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addCar";
    }

}