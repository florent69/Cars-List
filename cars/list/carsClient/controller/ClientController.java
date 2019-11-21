package cars.list.carsClient.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cars.list.carsClient.form.ClientForm;
import cars.list.carsClient.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class ClientController {

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

    //carList
    @RequestMapping(value = { "/carList" }, method = RequestMethod.GET)
    public String displayCarList(Model model) {
        String url = "http://localhost:9090/product";
        RestTemplate restTemplate = new RestTemplate();
        List<Car> cars = restTemplate.getForObject(url,List.class);
        model.addAttribute("cars", cars);
        return "carList";
    }

    //addCar GET
    @RequestMapping(value = { "/addCar" }, method = RequestMethod.GET)
    public String showAddCarPage(Model model) {
        ClientForm clientForm = new ClientForm();
        model.addAttribute("clientForm", clientForm);
        return "addCar";
    }

    //addCar POST
    @RequestMapping(value = { "/addCar" }, method = RequestMethod.POST)
    public String saveCar(Model model, @ModelAttribute("clientForm") ClientForm clientForm) {
        String brand = clientForm.getBrand();
        String name = clientForm.getName();

        if (brand != null && brand.length() > 0 && name != null && name.length() > 0) {
            String url = "http://localhost:9090/product";
            RestTemplate restTemplate = new RestTemplate();
            Map<String,String> requestMap = new HashMap<>();
            requestMap.put("brand", brand);
            requestMap.put("name", name);

            restTemplate.postForObject(url, requestMap, Car.class);
            return "redirect:/carList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addCar";
    }

}