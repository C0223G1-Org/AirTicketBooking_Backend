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
    private ICustomerRepository iCustomerRepository;

    /**
     * @param pageable
     *Create by: TàiMP
     *Date create: 10/08/2023
     *getListCustomer()
     *return: Page
     */
    @Override
    public Page<Customer> getListCustomer(Pageable pageable) {
        return iCustomerRepository.getListCustomer(pageable);
    }
    /**
     * @param pageable,email,name,nationality
     *Create by: TàiMP
     *Date create: 10/08/2023
     * Method: getListSearchCustomer()
     * return: Page
     */

    @Override
    public Page<Customer> getListSearchCustomer(Pageable pageable, String email, String name, String nationality) {
        return iCustomerRepository.getListSearchCustomer(pageable, email, name, nationality);
    }
    /**
     * @param id
     * Create by: TàiMP
     * Date create: 10/08/2023
     * Method: deleteCustomer()
     * return: void
     */

    @Override
    public void deleteCustomer(Long id) {
        iCustomerRepository.deleteCustomer(id);
    }
    /**
     * @param id
     * Create by: TàiMP
     * Date create: 10/08/2023
     * Method: findCustomerById()
     * return: Customer
     */

    @Override
    public Customer findCustomerById(Long id) {
        return iCustomerRepository.findCustomerById(id);
    }
}
