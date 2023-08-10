package com.example.air_ticket_booking.service.customer;

import com.example.air_ticket_booking.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ICustomerService {
    /**
     * @param pageable
     *Create by: TàiMP
     *Date create: 10/08/2023
     *getListCustomer()
     *return: Page
     */
    Page<Customer> getListCustomer(Pageable pageable);
    /**
     * @param pageable,email,name,nationality
     *Create by: TàiMP
     *Date create: 10/08/2023
     * Method: getListSearchCustomer()
     * return: Page
     */

    Page<Customer> getListSearchCustomer(Pageable pageable, String email, String name, String nationality);
    /**
     * @param id
     * Create by: TàiMP
     * Date create: 10/08/2023
     * Method: deleteCustomer()
     * return: void
     */

    void deleteCustomer(Long id);
    /**
     * @param id
     * Create by: TàiMP
     * Date create: 10/08/2023
     * Method: findCustomerById()
     * return: Customer
     */


//    Customer findCustomerById(Long id);
    /**
     * Create by: HoaLTY
     *      * Date create: 10/08/2023
     *      * Function:update customer information
     * @param customer
     */
    void updateCustomer(Customer customer);

    /**
     * Create by: HoaLTY
     *      * Date create: 10/08/2023
     *      * Function: get customer details by id
     * @param id
     * @return Customer
     */
    Customer findCustomerById(Long id);
}
