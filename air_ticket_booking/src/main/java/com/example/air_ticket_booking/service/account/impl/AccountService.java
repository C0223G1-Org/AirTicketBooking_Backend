package com.example.air_ticket_booking.service.account.impl;

import com.example.air_ticket_booking.dto.account.AccountDto;
import com.example.air_ticket_booking.model.account.Account;
import com.example.air_ticket_booking.model.employee.Employee;
import com.example.air_ticket_booking.repository.account.IAccountRepository;
import com.example.air_ticket_booking.service.account.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    /**
     * Create by: QuocNHA,
     * Date create : 10/08/2023
     * Function : create account
     * <p>
     *
     * @param accountDto
     * @return status update
     */
    @Override
    public void saveAccount(AccountDto accountDto) {
        Account account = new Account();
        BeanUtils.copyProperties(accountDto, account);
        accountRepository.addAccount(
                account.getPassword(),
                account.getUsername(),
                account.getRole().getIdRole()
        );
    }

    /**
     * Create by: QuocNHA,
     * Date create : 10/08/2023
     * Function : edit account
     * <p>
     *
     * @param accountDto
     * @return status update
     */
    @Override
    public void editAccount(Long id,AccountDto accountDto) {
        Account account = new Account();
        BeanUtils.copyProperties(accountDto,account);
        accountRepository.updateAccount(
                account.getIdAccount(),
                account.getPassword(),
                account.getUsername(),
                account.getIdAccount()
        );
    }

    /**
     * Create by: QuocNHA,
     * Date create : 10/08/2023
     * Function : edit account
     * <p>
     *
     * @param id
     * @return status update
     */
    @Override
    public Account findByyId(Long id) {
        return accountRepository.findByIdAccount(id);
    }
}
