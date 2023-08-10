package com.example.air_ticket_booking.service.customer.impl;

import com.example.air_ticket_booking.dto.account.AccountDto;
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


    /**
     * Create by: NhanDT
     * Date create: 10/08/2023
     * Function: declare function for use
     *
     * @Param: id
     * @Return: List<Customer>
     */
    @Override
    public List<Customer> findAllByEmail(String email) {
        return customerRepository.findAllByEmail(email);
    }
    /**
     * Create by: NhanDT
     * Date create: 10/08/2023
     * Function: declare function for use
     *
     * @Param: id
     * @Return: List<Customer>
     */
    @Override
    public void createCustomer(AccountDto accountDto, Long idAccountNew) {
        this.customerRepository.createCustomer(accountDto, idAccountNew);
    }
}
