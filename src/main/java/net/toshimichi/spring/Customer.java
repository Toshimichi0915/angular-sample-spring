package net.toshimichi.spring;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String username;

    public static Customer newCustomer(String email, String username) {
        Customer customer = new Customer();
        customer.email = email;
        customer.username = username;

        return customer;
    }
}
