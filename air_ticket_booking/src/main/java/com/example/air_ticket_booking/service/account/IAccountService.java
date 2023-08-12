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
    void updatePasswordForId(String newPass,String oldPass,Long idCustomer);

}
