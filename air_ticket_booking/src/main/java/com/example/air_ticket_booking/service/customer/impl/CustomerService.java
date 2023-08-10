package com.example.air_ticket_booking.service.customer.impl;

import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.repository.customer.ICustomerRepository;
import com.example.air_ticket_booking.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    /**
     *  Create by: HoaLTY
     *      * Date create: 10/08/2023
     *      * Function: update customer information
     * @param customer
     */
    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    /**
     * Create by: HoaLTY
     *      * Date create: 10/08/2023
     *      * Function: get customer details by id
     * @param id
     * @return Customer
     */
    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }

}