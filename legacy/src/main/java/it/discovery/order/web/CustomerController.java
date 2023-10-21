package it.discovery.order.web;

import it.discovery.monolith.domain.Customer;
import it.discovery.monolith.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @PostMapping
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}
