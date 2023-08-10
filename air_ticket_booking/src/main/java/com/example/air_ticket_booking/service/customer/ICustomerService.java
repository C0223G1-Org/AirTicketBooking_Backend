package com.example.air_ticket_booking.service.customer;

import com.example.air_ticket_booking.model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    /**
     * Create by: HungLV
     * Date create: 10/08/2023
     * Function:saveCustomer()
     *
     * @Param: customer
     * @Return: void
     */
    void saveCustomer(Customer customer);

    /**
     * Create by: HungLV
     * Date create: 10/08/2023
     * Function:updateCustomer()
     *
     * @Param: customer
     * @Return: void
     */

    void updateCustomer(Customer customer);

    /**
     * Create by: HungLV
     * Date create: 10/08/2023
     * Function:findCustomerById()
     *
     * @Param: id
     * @Return: Customer
     */

    Customer findCustomerById(Long id);

}
