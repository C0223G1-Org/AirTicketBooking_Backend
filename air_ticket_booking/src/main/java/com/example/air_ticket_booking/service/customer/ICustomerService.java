package com.example.air_ticket_booking.service.customer;

import com.example.air_ticket_booking.model.customer.Customer;



public interface ICustomerService {

    /**
     * Create by: HoaLTY
     *      * Date create: 10/08/2023
     *      * Function:updateCustomer()
     * @param customer
     */
    void updateCustomer(Customer customer);

    /**
     * Create by: HoaLTY
     *      * Date create: 10/08/2023
     *      * Function: findCustomerById()
     * @param id
     * @return Customer
     */
    Customer findCustomerById(Long id);

}