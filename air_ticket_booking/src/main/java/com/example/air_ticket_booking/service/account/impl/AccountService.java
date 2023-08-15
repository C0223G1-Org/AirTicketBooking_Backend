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
import java.util.Objects;
import java.util.Random;

/**
 * Created by: NhanDT
 * Date created: 10/08/2023
 * Function: Login , SignUp
 *
 * @param
 * @return
 */
@Service
public class AccountService implements UserDetailsService, IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailService emailService;

    /**
     * Created by: NhanDT
     * Date created: 10/08/2023
     * Function: Login , SignUp
     *
     * @param
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.getByUserNameAndStatusFalse(username);
        if (account == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        String role = account.getRole().getNameRole();
        authorities.add(new SimpleGrantedAuthority(role));

        return new JwtUserDetails(account.getIdAccount(), account.getUsername(), account.getPassword(), authorities);
    }

    /**
     * Created by: NhanDT
     * Date created: 10/08/2023
     * Function: Login , SignUp
     *
     * @param
     * @return
     */
    @Override
    public boolean signUp(AccountDto accountDto) {
        String email = accountDto.getEmailCustomer();
        String idCard = accountDto.getIdCardCustomer();
        Boolean checkExistAccount = checkExistAccount(email);
        Boolean checkExistCustomer = checkExistCustomer(email, idCard);
        if (checkExistAccount || checkExistCustomer) {
            return false;
        }
        String encoderPassword = passwordEncoder.encode(accountDto.getPassword());
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000;
        this.accountRepository.saveAccount(accountDto.getEmailCustomer(), encoderPassword, randomNumber);
        this.emailService.sendMail(email, "Mã xác nhận đăng ký", "Chào bạn, mã xác nhận đăng ký tài khoản của bạn là: \n " + randomNumber + "." +
                "\n" +
                "\n" +
                "\n" +
                "---------------------------------------" + "\n" +
                "CodeGymAirLines\n" +
                "Sđt: 0383767463\n" +
                "Email: codegymairC0223G1@gmail.com\n" +
                "Địa chỉ: 280 Trần Hưng Đạo, Sơn Trà, Đà Nẵng");
        Account accountNew = accountRepository.getByUserNameAndStatusFalse(email);
        if (accountNew == null) {
            return false;
        }
        this.customerService.createCustomer(accountDto, accountNew.getIdAccount());
        return checkExistAccount(email) == checkExistCustomer(email, idCard);
    }

    private boolean checkExistAccount(String email) {
        List<Account> accountList = accountRepository.findAllByUsername(email);
        return accountList.size() > 0;
    }

    private boolean checkExistCustomer(String email, String idCard) {
        List<Customer> customerList = customerService.findAllByEmailOrIdCard(email, idCard);
        return customerList.size() > 0;
    }

    /**
     * Created by: NhanDT
     * Date created: 10/08/2023
     * Function: Login , SignUp
     *
     * @param
     * @return
     */
    @Override
    public boolean checkCode(Account account) {
        Account accountCheck = accountRepository.getByUserNameAndStatusTrue(account.getUsername());
        if (Objects.equals(account.getVerificationCode(), accountCheck.getVerificationCode())) {
            this.accountRepository.setStatusToFalse(accountCheck.getIdAccount());
            this.accountRepository.setCodeToFalse(accountCheck.getIdAccount());
            return true;
        }
        return false;
    }

    @Override
    public void updatePasswordForCustomer(String newPass, String oldPass, Long idCustomer) {

    }

    @Override
    public void updatePasswordForEmployee(String newPass, String oldPass, Long idEmployee) {

    }


    @Override
    public List<Account> getList() {
        return accountRepository.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }
}
