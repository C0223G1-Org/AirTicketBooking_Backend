package com.example.air_ticket_booking.service.account;

import org.springframework.data.repository.query.Param;

public interface IAccountService {
    /**
     * create by : SangTDN
     * @param newPass
     * @param oldPass
     * @param idCustomer
     * @Return void
     */
    void updatePasswordForCustomer (String newPass,String oldPass,Long idCustomer);

    /**
     * create by : SangTDN
     * @param newPass
     * @param oldPass
     * @param idEmployee
     * @Return void
     */
    void updatePasswordForEmployee (String newPass,String oldPass,Long idEmployee);
}
