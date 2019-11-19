package cars.list.cars.controller;

import java.util.ArrayList;
import java.util.List;

import cars.list.cars.form.ProductForm;
import cars.list.cars.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private static List<Product> products = new ArrayList<Product>();

    static {
        products.add(new Product("Tesla", "Model S"));
        products.add(new Product("Volkswagen", "ID"));
    }

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = { "/productList" }, method = RequestMethod.GET)
    public String productList(Model model) {

        model.addAttribute("products", products);

        return "productList";
    }

    @RequestMapping(value = { "/addProduct" }, method = RequestMethod.GET)
    public String showAddProductPage(Model model) {

        ProductForm productForm = new ProductForm();
        model.addAttribute("productForm", productForm);

        return "addProduct";
    }

    @RequestMapping(value = { "/addProduct" }, method = RequestMethod.POST)
    public String saveProduct(Model model, //
                             @ModelAttribute("productForm") ProductForm productForm) {

        String brand = productForm.getBrand();
        String name = productForm.getName();

        if (brand != null && brand.length() > 0 //
                && name != null && name.length() > 0) {
            Product newProduct = new Product(brand, name);
            products.add(newProduct);

            return "redirect:/productList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addProduct";
    }

}