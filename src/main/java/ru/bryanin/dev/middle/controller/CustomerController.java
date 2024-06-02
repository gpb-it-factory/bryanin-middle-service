package ru.bryanin.dev.middle.controller;

import org.springframework.web.bind.annotation.*;
import ru.bryanin.dev.middle.service.CustomerService;

import static ru.bryanin.dev.middle.utils.Util.customerIdFromJsonToLong;

@RestController
@RequestMapping("/users")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping()
    public String registerCustomer(@RequestBody String json) throws Exception {
        Long telegramId = customerIdFromJsonToLong(json);
        return customerService.registerCustomer(telegramId);
    }
}
