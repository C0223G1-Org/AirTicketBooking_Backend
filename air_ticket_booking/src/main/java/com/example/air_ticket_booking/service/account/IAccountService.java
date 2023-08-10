package com.example.air_ticket_booking.service.account;

import org.springframework.data.repository.query.Param;

public interface IAccountService {
    void updatePasswordForCustomer (String newPass,String oldPass,Long idCustomer);
    void updatePasswordForEmployee (String newPass,String oldPass,Long idEmployee);
}
