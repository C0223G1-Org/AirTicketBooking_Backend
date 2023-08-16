package com.example.air_ticket_booking.service.customer.impl;

import com.example.air_ticket_booking.dto.account.AccountDto;
import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.repository.customer.ICustomerRepository;
import com.example.air_ticket_booking.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    /**
     *  Create by: HoaLTY, HungLV
     *  Date create: 10/08/2023
     *  Function: get data from controller and call method of customer-repository execute process
     * @param customer
     * @Return: void
     */
    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    /**
     * Create by: HoaLTY,HungLV,TaiMP
     * Date create: 10/08/2023
     * Function: get customer details by id
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
     * Create by: HungLV
     * Date create: 10/08/2023
     * Function:get data from controller and call method of customer-repository execute process
     * @Param: customer
     * @Return: void
     */
    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
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

    /**
     * Create by: NhanDT
     * Date create: 10/08/2023
     * Function: declare function for use
     *
     * @Param: id
     * @Return: List<Customer>
     */
    @Override
    public List<Customer> findAllByEmailOrIdCard(String email) {
        return customerRepository.findAllByEmailOrIdCard(email);
    }
}

