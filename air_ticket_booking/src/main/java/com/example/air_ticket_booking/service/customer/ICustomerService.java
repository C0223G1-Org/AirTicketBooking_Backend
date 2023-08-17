package com.example.air_ticket_booking.service.customer;

import com.example.air_ticket_booking.dto.account.AccountDto;
import com.example.air_ticket_booking.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    /**
     * @param pageable Create by: TàiMP
     *                 Date create: 10/08/2023
     *                 Method: declare function for use
     *                 return: Page
     */
    Page<Customer> getListCustomer(Pageable pageable);

    /**
     * @param pageable,email,name,nationality Create by: TàiMP
     *                                        Date create: 10/08/2023
     *                                        Method: declare function for use
     *                                        return: Page
     */
    Page<Customer> getListSearchCustomer(Pageable pageable, String email, String name, String nationality);

    /**
     * @param id Create by: TàiMP
     *           Date create: 10/08/2023
     *           Method: declare function for use
     *           return: void
     */
    void deleteCustomer(Long id);


    /**
     * Create by: HoaLTY, TaiMP, HungLV
     * Date create: 10/08/2023
     * Function: declare function for use
     *
     * @param id
     * @return Customer
     */
    Customer findCustomerById(Long id);

    /**
     * Create by: HungLV
     * Date create: 10/08/2023
     * Function: declare function for use
     *
     * @Param: customer
     * @Return: void
     */
    void saveCustomer(Customer customer);

    /**
     * Create by: HungLV, HoaLTY
     * Date create: 10/08/2023
     * Function: declare function for use
     *
     * @Param: customer
     * @Return: void
     */

    void updateCustomer(Customer customer);

    /**
     * Create by: NhanDT
     * Date create: 10/08/2023
     * Function: declare function for use
     *
     * @Param: id
     * @Return: List<Customer>
     */
    List<Customer> findAllByEmailOrIdCard(String email);


    /**
     * Create by: NhanDT
     * Date create: 10/08/2023
     * Function: declare function for use
     *
     * @Param: id
     * @Return: List<Customer>
     */
    void createCustomer(AccountDto accountDto, Long idAccountNew);

    Customer getCustomerLoginByEmail(String email);
}