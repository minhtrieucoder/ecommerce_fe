package ute.ecommerce_fe.controllers.admin;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import ute.ecommerce_fe.models.Category;
import org.springframework.stereotype.Controller;


@Controller
public class CategoryController {
    private final String CATEGORY_API_URL = "http://localhost:4202/category/all";

    private final String CATEGORY_API_URL2 = "http://localhost:4202/category/new";

    private final String CATEGORY_API_URL3 = "http://localhost:4202/category/update";


    @GetMapping("/categories")
    public String getAllCategory(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        // Make a GET request to the API endpoint
        Category[] categories = restTemplate.getForObject(CATEGORY_API_URL, Category[].class);

        // Add the retrieved data to the model
        model.addAttribute("categories", categories);

        // Return the Thymeleaf view name
        return "category-list";
    }

    @GetMapping("/categories/new")
    public String showCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "category-form";
    }

    // Handling the form submission to create a new provider
    @PostMapping("/categories/new")
    public String createNewCategory(@ModelAttribute Category category) {

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.postForObject(CATEGORY_API_URL2, category, Category.class);

        return "redirect:/categories";
    }

    @GetMapping("/categories/update")
    public String showUpdateCategoryForm( Model model) {

        Category existingCategory = new Category();

        model.addAttribute("category", existingCategory);
        return "category-update-form";
    }

    @PostMapping("/categories/update")
    public String updateCategory(@ModelAttribute Category category) {

        RestTemplate restTemplate = new RestTemplate();


        String updateUrl = CATEGORY_API_URL3;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Category> request = new HttpEntity<>(category, headers);


        restTemplate.put(updateUrl, request, Category.class);

        return "redirect:/categories";
    }
}
