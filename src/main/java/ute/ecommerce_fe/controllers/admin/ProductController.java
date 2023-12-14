package ute.ecommerce_fe.controllers.admin;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import ute.ecommerce_fe.models.Product;


@Controller

public class ProductController {

    private final String PRODUCT_API_URL = "http://localhost:4202/product/all";
    private final String PRODUCT_API_URL2 = "http://localhost:4202/product/new";

    private final String PRODUCT_API_URL3 = "http://localhost:4202/product/update";
    private RestOperations restTemplate;

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        Product[] products = restTemplate.getForObject(PRODUCT_API_URL, Product[].class);

        model.addAttribute("products", products);

        return "product-list";
    }

    @GetMapping("/products/new")
    public String showProviderForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    // Handling the form submission to create a new provider
    @PostMapping("/products/new")
    public String createNewProduct(@ModelAttribute Product product) {
        RestTemplate restTemplate = new RestTemplate();


        restTemplate.postForObject(PRODUCT_API_URL2, product, Product.class);


        return "redirect:/products";
    }

    @GetMapping("/products/{id}/update")
    public String showUpdateProductForm(@PathVariable("id") Long id, Model model) {

        Product existingProduct = new Product();
        existingProduct.setId(id);

        model.addAttribute("product", existingProduct);
        return "product-update-form";
    }

    @PostMapping("/products/update")
    public String updateProduct(@ModelAttribute Product product) {

        RestTemplate restTemplate = new RestTemplate();


        String updateUrl = PRODUCT_API_URL3;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Product> request = new HttpEntity<>(product, headers);


        restTemplate.put(updateUrl, request, Product.class);

        return "redirect:/products";
    }
}
