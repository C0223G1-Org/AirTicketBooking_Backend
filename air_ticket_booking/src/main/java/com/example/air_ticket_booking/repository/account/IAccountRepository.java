package com.example.air_ticket_booking.repository.account;

import com.example.air_ticket_booking.model.account.Account;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IAccountRepository extends JpaRepository<Account, Integer> {

}
