package net.toshimichi.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerData> getCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("{id}")
    public Optional<CustomerData> getCustomerById(@PathVariable String id) {
        return customerService.findCustomerById(Long.parseLong(id));
    }

    @PostMapping
    public void postCustomer(@RequestBody CustomerData customerData) {
        customerService.addCustomer(customerData);
    }
}
