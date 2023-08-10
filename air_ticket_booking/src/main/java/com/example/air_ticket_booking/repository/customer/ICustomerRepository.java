package com.example.air_ticket_booking.repository.customer;

import com.example.air_ticket_booking.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Long> {


    /**
     * Create by: HoaLTY
     *      * Date create: 10/08/2023
     *      * Function:update customer information
     * @param customer
     */
    @Modifying
    @Query(value = "update customer set name_customer =:#{#customer.nameCustomer} ,gender_customer = :#{#customer.genderCustomer}," +
            " email_customer =:#{#customer.emailCustomer} , date_customer =:#{#customer.dateCustomer} ," +
            "id_card_customer=:#{#customer.idCardCustomer} , address_customer =:#{#customer.addressCustomer} , flag_customer= :#{#customer.flagCustomer}" +
            ", img_customer =:#{#customer.imgCustomer} , tel_customer =:#{#customer.telCustomer} ,nationality_customer = :#{#customer.nationalityCustomer}," +
            "account_id_account = :#{#customer.account.idAccount} where id_customer = :#{#customer.idCustomer}"
            ,nativeQuery = true)
    void updateCustomer(@Param("customer") Customer customer);

    /**
     * Create by: HoaLTY
     *      * Date create: 10/08/2023
     *      * Function: get customer details by id
     * @param id
     * @return Customer
     */
    @Query(value = "select customer.name_customer,customer.gender_customer,customer.email_customer,customer.date_customer,customer.id_card_customer,customer.address_customer," +
            "customer.img_customer,customer.tel_customer,customer.nationality_customer" +
            " from customer where id_customer = :id and flag_customer=false",nativeQuery = true)
    Customer findCustomerById(@Param("id") Long id);
}
