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
import ute.ecommerce_fe.models.Order;



@Controller

public class OrderController {

    private final String ORDER_API_URL = "http://localhost:4202/order/all";
    private final String ORDER_API_URL2 = "http://localhost:4202/order/new";

    private final String ORDER_API_URL3 = "http://localhost:4202/order/update";
    private RestOperations restTemplate;

    @GetMapping("/orders")
    public String getAllOrders(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        Order[] orders = restTemplate.getForObject(ORDER_API_URL, Order[].class);

        model.addAttribute("orders", orders);

        return "order-list";
    }

    @GetMapping("/orders/new")
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "order-form";
    }

    // Handling the form submission to create a new provider
    @PostMapping("/orders/new")
    public String createNewOrder(@ModelAttribute Order order) {
        RestTemplate restTemplate = new RestTemplate();


        restTemplate.postForObject(ORDER_API_URL2, order, Order.class);


        return "redirect:/orders";
    }

    @GetMapping("/orders/{id}/update")
    public String showUpdateProductForm(@PathVariable("id") Long id, Model model) {

        Order existingOrder = new Order();
        existingOrder.setId(id);

        model.addAttribute("order", existingOrder);
        return "order-update-form";
    }

    @PostMapping("/orders/update")
    public String updateProduct(@ModelAttribute Order order) {

        RestTemplate restTemplate = new RestTemplate();


        String updateUrl = ORDER_API_URL3;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Order> request = new HttpEntity<>(order, headers);


        restTemplate.put(updateUrl, request, Order.class);

        return "redirect:/orders";
    }
}
