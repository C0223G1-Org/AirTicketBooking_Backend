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
   @Query(value = " select * from customer where flag_customer=false",nativeQuery = true)
   Page<Customer> getListCustomer(Pageable pageable);
   @Query(value = "select * from customer where email_customer like concat('%',:email,'%') and name_customer" +
           " like concat('%',:name,'%') and nationality_customer like concat('%',:nationality,'%') " +
           "and flag_customer = false",nativeQuery = true)
   Page<Customer> getListSearchCustomer(Pageable pageable, @Param("email") String email,@Param("name") String name, @Param("nationality") String nationality);
   @Modifying
   @Query(value = "update customer set flag_customer=true where id_customer = :id and flag_customer=false",nativeQuery = true)
   void deleteCustomer(@Param("id") Long id);

   @Query(value = "select * from customer where id_customer=:id and flag_customer=false ",nativeQuery = true)
   Customer findCustomerById(@Param("id")Long id);
}
