package com.example.air_ticket_booking.service.customer.impl;

import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.repository.customer.ICustomerRepository;
import com.example.air_ticket_booking.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    /**
     * Create by: HungLV
     * Date create: 10/08/2023
     * Function:get data from controller and call method of customer-repository execute process
     *
     * @Param: customer
     * @Return: void
     */
    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
    }

    /**
     * Create by: HungLV
     * Date create: 10/08/2023
     * Function:get data from controller and call method of customer-repository execute process
     *
     * @Param: customer
     * @Return: void
     */

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    /**
     * Create by: HungLV
     * Date create: 10/08/2023
     * Function:findCustomerById()
     *
     * @Param: id
     * @Return: Customer
     */

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }

}
