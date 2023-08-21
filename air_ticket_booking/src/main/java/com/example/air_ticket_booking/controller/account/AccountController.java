package com.example.air_ticket_booking.controller.account;
import com.example.air_ticket_booking.config.JwtTokenUtil;
import com.example.air_ticket_booking.config.JwtUserDetails;
import com.example.air_ticket_booking.dto.account.AccountDto;
import com.example.air_ticket_booking.dto.account.JwtRequestDto;
import com.example.air_ticket_booking.model.account.Account;
import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.reponse.JwtRequest;
import com.example.air_ticket_booking.reponse.JwtResponse;
import com.example.air_ticket_booking.service.account.IAccountService;
import com.example.air_ticket_booking.service.account.impl.AccountService;
import com.example.air_ticket_booking.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import com.example.air_ticket_booking.dto.account.AccountChangeDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by: NhanDT
 * Date created: 10/08/2023
 * Function: Login , SignUp
 *
 * @param
 * @return
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    class ErrorInfo {
        private String error;
        private String useName;
        public ErrorInfo(String error, String useName) {
            this.error = error;
            this.useName = useName;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getId() {
            return useName;
        }

        public void setId(String useName) {
            this.useName = useName;
        }
    }

    /**
     * Created by: NhanDT
     * Date created: 10/08/2023
     * Function: Login , SignUp
     *
     * @param
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<?> loginAuthentication(@RequestBody JwtRequest authenticationRequest) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            JwtUserDetails principal = (JwtUserDetails) authentication.getPrincipal();
            GrantedAuthority authority = principal.getAuthorities().stream().findFirst().orElse(null);
            final String token = jwtTokenUtil.generateToken(principal.getUsername());
            return ResponseEntity.ok(new JwtResponse(token, principal.getUsername(), authority != null ? authority.getAuthority() : null));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Đăng nhập thất bại!!!");
        }
    }

    /**
     * Created by: NhanDT
     * Date created: 10/08/2023
     * Function: Login , SignUp
     *
     * @param
     * @return
     */
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody AccountDto accountDto) {
        if (accountService.signUp(accountDto)) {
            return ResponseEntity.ok(new JwtResponse(accountDto.getEmailCustomer()));
        }
//        String encoderPassword = passwordEncoder.encode(accountDto.getPassword());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Đăng ký tài khoản không thành công");
    }

    /**
     * Created by: NhanDT
     * Date created: 14/08/2023
     * Function: checkCode
     *
     * @param account
     * @return boolean
     */
    @PostMapping("/checkCode")
    public ResponseEntity<?> checkCode(@RequestBody AccountDto account) {
        boolean check = accountService.checkCode(account);
        try {
            if (check) {
                return ResponseEntity.ok(new JwtResponse(account.getEmailCustomer()));
            } else {
                ErrorInfo errorInfo = new ErrorInfo("Xác nhận mã thất bại!!", account.getEmailCustomer());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
            }
        } catch (Exception e) {
            ErrorInfo errorInfo = new ErrorInfo("Xác nhận mã thất bại!!", account.getEmailCustomer());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
        }

    }



    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * @param
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    /**
     //     * create by : SangTDN
     //     * @param id
     //     * @param accountChangeDTO
     //     * @return status
     //     */
    @PatchMapping("/{id}")
//    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER','ROLE_EMPLOYEE','ROLE_ADMIN')")
    public ResponseEntity<?> updateAccount(@Valid @RequestBody AccountChangeDTO accountChangeDTO, @PathVariable Long id) {
        Account account = accountService.findAccountById(id);
        boolean flag = passwordEncoder.matches(accountChangeDTO.getOldPassword(), account.getPassword());
        if (flag) {
            String encoderNewPassword = passwordEncoder.encode(accountChangeDTO.getNewPassword());
            accountService.updatePasswordForId(encoderNewPassword, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Account> getAccountByGmail ( @PathVariable String email){
        Account account = accountService.findAccountByEmail(email);
        if (account==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account,HttpStatus.OK);
    }
}
