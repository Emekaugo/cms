package com.example.cms.service;

import com.example.cms.dao.CustomerDAO;
import com.example.cms.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.cms.model.Customer;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;


    public Customer addCustomer(Customer customer) {
        return customerDAO.save(customer);
    }

    public List<Customer> getCustomers() {
        return customerDAO.findAll();
    }

    public Customer getCustomer(int customerId) {
        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer Record is not available...");
        return optionalCustomer.get();
    }

    public Customer updateCustomer(int customerId, Customer customer) {
        customer.setCustomerId(customerId);
        return customerDAO.save(customer);
    }

    public void deleteCustomer(int customerId) {
        customerDAO.deleteById(customerId);
    }

//    private int customerIdCount=1;
//
//    private List<Customer> customerList = new CopyOnWriteArrayList<>();
//
//    public Customer addCustomer(Customer customer) {
//        customer.setCustomerId(customerIdCount);
//        customerList.add(customer);
//        customerList.add(customer);
//        customerIdCount++;
//        return customer;
//    }
//
//    public List<Customer> getCustomers() {
//        return customerList;
//    }
//
//    public Customer getCustomer(int customerId) {
//        return customerList
//                .stream()
//                .filter(c -> c.getCustomerId()==customerId)
//                .findFirst()
//                .get();
//    }
//
//    public Customer updateCustomer(int customerId, Customer customer) {
//        customerList
//                .stream()
//                .forEach(c->{
//                    if(c.getCustomerId() == customerId)
//                    {
//                        c.setCustomerFirstName(customer.getCustomerFirstName());
//                        c.setCustomerLastName(customer.getCustomerLastName());
//                        c.setCustomerEmail(customer.getCustomerEmail());
//                    }
//                });
//        return customerList
//                .stream()
//                .filter(c -> c.getCustomerId()==customerId)
//                .findFirst()
//                .get();
//    }
//
//    public void deleteCustomer(int customerId) {
//
//        customerList
//                .stream()
//                .forEach(c -> {
//                    if (c.getCustomerId() == customerId) {
//                        customerList.remove(c);
//                    }
//                });
//    }

}
