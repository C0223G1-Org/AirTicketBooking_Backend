package com.example.air_ticket_booking.repository.account;

import com.example.air_ticket_booking.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account,Long> {
    Account findByUsername(String username);
}
