package ute.ecommerce_fe.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ute.ecommerce_fe.models.Order;
import ute.ecommerce_fe.models.Provider;

@Controller

public class DashController {
    private final String HOME_API_URL = "http://localhost:4202/order/totalOrdersToday";
    private final String HOME_API_URL2 = "http://localhost:4202/order/totalOrdersThisMonth";

    private final String HOME_API_URL3 = "http://localhost:4202/order/totalAmountToday";

    private final String HOME_API_URL4 = "http://localhost:4202/order/totalAmountThisMonth";
    private final String HOME_API_URL5 = "http://localhost:4202/order/filter?state=Cho";

    private final String HOME_API_URL6 = "http://localhost:4202/order/countOfWaitingOrders";

    @GetMapping("/home")
    public String getAllProviders(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        Integer totalOrdersToday = restTemplate.getForObject(HOME_API_URL, Integer.class);
        model.addAttribute("totalOrdersToday", totalOrdersToday);

        Integer totalOrdersThisMonth = restTemplate.getForObject(HOME_API_URL2, Integer.class);
        model.addAttribute("totalOrdersThisMonth", totalOrdersThisMonth);

        Integer totalAmountToday = restTemplate.getForObject(HOME_API_URL3, Integer.class);
        model.addAttribute("totalAmountToday", totalAmountToday);

        Integer totalAmountThisMonth = restTemplate.getForObject(HOME_API_URL4, Integer.class);
        model.addAttribute("totalAmountThisMonth", totalAmountThisMonth);


//        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(HOME_API_URL5)
//                .queryParam("state", "Chờ xác nhận");
        Order[] orderWaiting = restTemplate.getForObject(HOME_API_URL5, Order[].class);

        model.addAttribute("orderWaiting", orderWaiting);

        Integer countOfWaitingOrders = restTemplate.getForObject(HOME_API_URL6, Integer.class);
        model.addAttribute("countOfWaitingOrders", countOfWaitingOrders);

        return "dashboard";
    }
}
