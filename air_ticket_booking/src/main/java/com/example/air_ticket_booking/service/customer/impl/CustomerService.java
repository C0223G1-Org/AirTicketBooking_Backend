package com.example.air_ticket_booking.service.customer.impl;

import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.repository.customer.ICustomerRepository;
import com.example.air_ticket_booking.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    /**
     * @param pageable
     *Create by: TàiMP
     *Date create: 10/08/2023
     *Method : get all the information of the customers in DB
     *return: Page
     */
    @Override
    public Page<Customer> getListCustomer(Pageable pageable) {
        return customerRepository.getListCustomer(pageable);
    }
    /**
     * @param pageable,email,name,nationality
     *Create by: TàiMP
     *Date create: 10/08/2023
     * Method: getListSearchCustomer() get pageable, email, name, nationality from CustomerController
     * return: Page
     */

    @Override
    public Page<Customer> getListSearchCustomer(Pageable pageable, String email, String name, String nationality) {
        return customerRepository.getListSearchCustomer(pageable, email, name, nationality);
    }
    /**
     * @param id
     * Create by: TàiMP
     * Date create: 10/08/2023
     * Method: deleteCustomer() get id from CustomerController
     * return: void
     */

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteCustomer(id);
    }
    /**
     * @param id
     * Create by: TàiMP
     * Date create: 10/08/2023
     * Method: findCustomerById() get id from CustomerController
     * return: Customer
     */

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }
}
