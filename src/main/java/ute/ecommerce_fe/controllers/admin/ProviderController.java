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
import ute.ecommerce_fe.models.Provider;

@Controller

public class ProviderController {

    private final String PROVIDER_API_URL = "http://localhost:4202/provider/all";
    private final String PROVIDER_API_URL2 = "http://localhost:4202/provider/new";

    private final String PROVIDER_API_URL3 = "http://localhost:4202/provider/update";
    private RestOperations restTemplate;

    @GetMapping("/providers")
    public String getAllProviders(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        Provider[] providers = restTemplate.getForObject(PROVIDER_API_URL, Provider[].class);

        model.addAttribute("providers", providers);

        return "provider-list";
    }

    @GetMapping("/providers/new")
    public String showProviderForm(Model model) {
        model.addAttribute("provider", new Provider());
        return "provider-form";
    }

    // Handling the form submission to create a new provider
    @PostMapping("/providers/new")
    public String createNewProvider(@ModelAttribute Provider provider) {
        RestTemplate restTemplate = new RestTemplate();


        restTemplate.postForObject(PROVIDER_API_URL2, provider, Provider.class);


        return "redirect:/providers";
    }

    @GetMapping("/providers/update")
    public String showUpdateProviderForm( Model model) {

        Provider existingProvider = new Provider();

        model.addAttribute("provider", existingProvider);
        return "provider-update-form";
    }

    @PostMapping("/providers/update")
    public String updateProvider(@ModelAttribute Provider provider) {

        RestTemplate restTemplate = new RestTemplate();


        String updateUrl = PROVIDER_API_URL3;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Provider> request = new HttpEntity<>(provider, headers);


        restTemplate.put(updateUrl, request, Provider.class);

        return "redirect:/providers";
    }
}
