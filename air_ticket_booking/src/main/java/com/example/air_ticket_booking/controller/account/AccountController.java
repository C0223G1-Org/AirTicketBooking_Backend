package com.example.air_ticket_booking.controller.account;

import com.example.air_ticket_booking.config.JwtTokenUtil;
import com.example.air_ticket_booking.config.JwtUserDetails;
//import com.example.air_ticket_booking.dto.account.AccountChangeDTO;
import com.example.air_ticket_booking.dto.account.AccountDto;
import com.example.air_ticket_booking.dto.account.JwtRequestDto;
import com.example.air_ticket_booking.model.account.Account;
import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.reponse.JwtRequest;
import com.example.air_ticket_booking.reponse.JwtResponse;
import com.example.air_ticket_booking.service.account.impl.AccountService;
import com.example.air_ticket_booking.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

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
    private AccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    class ErrorInfo {
        private String error;
        private Long id;


    }

    /**
     * create by : SangTDN
     * @param id
     * @param accountChangeDTO
     * @return status
     */
//    @PatchMapping("/{id}")
//    public ResponseEntity<?> updateAccount(@Valid @RequestBody AccountChangeDTO accountChangeDTO, @PathVariable Long id) {
//        Account account = accountService.findAccountById(id);
//        boolean flag = passwordEncoder.matches(accountChangeDTO.getOldPassword(), account.getPassword());
//        if (flag) {
//            String encoderNewPassword = passwordEncoder.encode(accountChangeDTO.getNewPassword());
//            accountService.updatePasswordForId(encoderNewPassword, id);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

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
    public ResponseEntity<?> signUp(@Valid @RequestBody AccountDto accountDto){
        if (accountService.signUp(accountDto)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
//        String encoderPassword = passwordEncoder.encode(accountDto.getPassword());
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
}
