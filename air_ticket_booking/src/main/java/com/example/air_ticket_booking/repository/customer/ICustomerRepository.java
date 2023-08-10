package com.example.air_ticket_booking.repository.customer;

import com.example.air_ticket_booking.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
   /**
    * @param pageable
    *Create by: TàiMP
    *Date create: 10/08/2023
    *Method: get all the information of the customers and have flag_customer = flase in DB
    *return: Page
    */
   @Query(value = " select * from customer where flag_customer=false",nativeQuery = true)
   Page<Customer> getListCustomer(Pageable pageable);
   /**
    * @param pageable,email,name,nationality
    *Create by: TàiMP
    *Date create: 10/08/2023
    * Method: get list customers by passing param email,name,nationality to @Query and get data from DB
    * return: Page
    */

   @Query(value = " select customer.id_customer,customer.name_customer,customer.gender_customer,customer.email_customer," +
           "customer.date_customer,customer.id_card_customer,customer.address_customer,customer.flag_customer,customer.img_customer," +
           "customer.tel_customer,customer.nationality_customer,customer.account_id_account " +
           "from customer where email_customer " +
           "like concat('%',:email,'%') and name_customer" +
           " like concat('%',:name,'%') and nationality_customer like concat('%',:nationality,'%') " +
           "and flag_customer = false",nativeQuery = true)
   Page<Customer> getListSearchCustomer(Pageable pageable, @Param("email") String email,@Param("name") String name, @Param("nationality") String nationality);
   /**
    * @param id
    * Create by: TàiMP
    * Date create: 10/08/2023
    * Method: delete by passing param id to @Query set flag_customer = true
    * return: void
    */
   @Modifying
   @Query(value = "update customer set flag_customer=true where id_customer = :id and flag_customer=false",nativeQuery = true)
   void deleteCustomer(@Param("id") Long id);
   /**
    *  @param id
    * Create by: TàiMP
    * Date create: 10/08/2023
    * Method: find customer passing param id to @Query and get data from DB
    * return: Customer
    */
//   @Query(value = "select customer.id_customer,customer.name_customer,customer.gender_customer,customer.email_customer," +
//           "customer.date_customer,customer.id_card_customer,customer.address_customer,customer.flag_customer," +
//           "customer.img_customer,customer.tel_customer,customer.nationality_customer,customer.account_id_account" +
//           " from customer where id_customer = :id and flag_customer=false",nativeQuery = true)
//   Customer findCustomerById(@Param("id") Long id);
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
   @Query(value = "select customer.id_customer,customer.name_customer,customer.gender_customer,customer.email_customer,customer.date_customer,customer.id_card_customer,customer.address_customer,customer.flag_customer," +
           "customer.img_customer,customer.tel_customer,customer.nationality_customer,customer.account_id_account" +
           " from customer where id_customer = :id and flag_customer=false",nativeQuery = true)
   Customer findCustomerById(@Param("id") Long id);

    /**
     * Create by: HungLV
     * Date create: 10/08/2023
     * Function: get data from service and insert fields of customers into database
     *
     * @Param: customer
     * @Return: void
     */
    @Modifying
    @Query(value = "insert into customer(name_customer,gender_customer, email_customer, date_customer," +
            "id_card_customer, address_customer, flag_customer, img_customer, tel_customer,nationality_customer,account_id_account)" +
            "values (:#{#customer.nameCustomer},:#{#customer.genderCustomer},:#{#customer.emailCustomer},:#{#customer.dateCustomer}" +
            ",:#{#customer.idCardCustomer},:#{#customer.addressCustomer},:#{#customer.flagCustomer},:#{#customer.imgCustomer}," +
            ":#{#customer.telCustomer},:#{#customer.nationalityCustomer},:#{#customer.account.idAccount})", nativeQuery = true)
    void saveCustomer(@Param("customer") Customer customer);

    /**
     * Create by: HungLV
     * Date create: 10/08/2023
     * Function:get data from service and update fields of customers into database following id
     *
     * @Param: customer
     * @Return: void
     */

//    @Modifying
//    @Query(value = "update customer set name_customer =:#{#customer.nameCustomer} ,gender_customer = :#{#customer.genderCustomer}," +
//            " email_customer =:#{#customer.emailCustomer} , date_customer =:#{#customer.dateCustomer} ," +
//            "id_card_customer=:#{#customer.idCardCustomer} , address_customer =:#{#customer.addressCustomer} , flag_customer= :#{#customer.flagCustomer}" +
//            ", img_customer =:#{#customer.imgCustomer} , tel_customer =:#{#customer.telCustomer} ,nationality_customer = :#{#customer.nationalityCustomer}," +
//            "account_id_account = :#{#customer.account.idAccount} where id_customer = :#{#customer.idCustomer}"
//            , nativeQuery = true)
//    void updateCustomer(@Param("customer") Customer customer);

    /**
     * Create by: HungLV
     * Date create: 10/08/2023
     * Function:get id from service and get all fields of customer
     *
     * @Param: id
     * @Return: Customer
     */

//    @Query(value = "select * from customer where id_customer = :id and flag_customer=false", nativeQuery = true)
//    Customer findCustomerById(@Param("id") Long id);
}
