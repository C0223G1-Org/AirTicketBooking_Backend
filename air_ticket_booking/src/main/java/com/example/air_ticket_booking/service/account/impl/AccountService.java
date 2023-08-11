package com.example.air_ticket_booking.service.account.impl;

import com.example.air_ticket_booking.config.JwtUserDetails;
import com.example.air_ticket_booking.dto.account.AccountDto;
import com.example.air_ticket_booking.model.account.Account;
import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.repository.account.IAccountRepository;
import com.example.air_ticket_booking.service.account.IAccountService;
import com.example.air_ticket_booking.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: NhanDT
 * Date created: 10/08/2023
 * Function: Login , SignUp
 *
 * @param
 * @return
 */
@Service
public class AccountService implements UserDetailsService,IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        String role = account.getRole().getNameRole();
        authorities.add(new SimpleGrantedAuthority(role));

        return new JwtUserDetails(account.getIdAccount(),account.getUsername(), account.getPassword(), authorities);
    }

    @Override
    public boolean signUp(AccountDto accountDto) {
        String email = accountDto.getEmailCustomer();
        Boolean checkExistAccount = checkExistAccount(email);
        Boolean checkExistCustomer = checkExistCustomer(email);
        if(checkExistAccount || checkExistCustomer){
            return false;
        }
        String encoderPassword = passwordEncoder.encode(accountDto.getPassword());
        this.accountRepository.saveAccount(accountDto.getEmailCustomer(),encoderPassword);
        Account accountNew = accountRepository.findByUsername(email);
        if(accountNew == null){
            return false;
        }
        this.customerService.createCustomer(accountDto,accountNew.getIdAccount());
        return checkExistAccount(email) == checkExistCustomer(email);
    }

    @Override
    public void updatePasswordForCustomer(String newPass, String oldPass, Long idCustomer) {

    }

    @Override
    public void updatePasswordForEmployee(String newPass, String oldPass, Long idEmployee) {

    }

    private boolean checkExistAccount(String email){
        List<Account> accountList = accountRepository.findAllByUsername(email);
        return accountList.size() > 0;
    }
    private boolean checkExistCustomer(String email){
        List<Customer> customerList = customerService.findAllByEmail(email);
        return customerList.size() > 0;
    }
}
