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

//    @Override
//    public Customer findCustomerById(Long id) {
//        return customerRepository.findCustomerById(id);
//    }
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

//    @Override
//    public void updateCustomer(Customer customer) {
//        customerRepository.updateCustomer(customer);
//    }

    /**
     * Create by: HungLV
     * Date create: 10/08/2023
     * Function:findCustomerById()
     *
     * @Param: id
     * @Return: Customer
     */

//    @Override
//    public Customer findCustomerById(Long id) {
//        return customerRepository.findCustomerById(id);
//    }


}