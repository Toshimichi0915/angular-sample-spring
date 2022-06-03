package net.toshimichi.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public void addCustomer(CustomerData customerData) {
        Customer customer = Customer.newCustomer(customerData.getEmail(), customerData.getUsername());
        customerRepository.save(customer);
    }

    @Transactional(readOnly = true)
    public Optional<CustomerData> findCustomerById(Long id) {
        return customerRepository.findById(id).map(CustomerData::fromCustomer);
    }

    @Transactional
    public List<CustomerData> findAllCustomers() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .map(CustomerData::fromCustomer)
                .toList();
    }
}
