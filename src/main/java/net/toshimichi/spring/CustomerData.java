package net.toshimichi.spring;

import lombok.Data;

@Data
public class CustomerData {

    private String email;
    private String username;

    public static CustomerData fromCustomer(Customer customer) {
        CustomerData customerData = new CustomerData();
        customerData.email = customer.getEmail();
        customerData.username = customer.getUsername();

        return customerData;
    }
}
