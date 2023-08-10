package com.example.air_ticket_booking.service.customer;

import com.example.air_ticket_booking.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ICustomerService {
    Page<Customer> getListCustomer(Pageable pageable);

    Page<Customer> getListSearchCustomer(Pageable pageable, String email, String name, String nationality);

    void deleteCustomer(Long id);

    Customer findCustomerById(Long id);
}
