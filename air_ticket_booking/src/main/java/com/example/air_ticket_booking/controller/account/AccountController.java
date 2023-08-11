package com.example.air_ticket_booking.controller.account;

import com.example.air_ticket_booking.dto.account.PassDto;
import com.example.air_ticket_booking.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    /**
     * create by: SangTDN
     * @param newPass
     * @param oldPass
     * @param idCustomer
     * @return status
     */
    @PatchMapping("/change-pass-customer/{newPass}/{oldPass}/{idCustomer}")
    public ResponseEntity<?> updatePasswordForCustomer (@Valid @PathVariable PassDto newPass, @PathVariable String oldPass,
                                                        @PathVariable Long idCustomer){
        accountService.updatePasswordForCustomer(newPass.getPassword(),oldPass,idCustomer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * create by: SangTDN
     * @param newPass
     * @param oldPass
     * @param idEmployee
     * @return status
     */
    @PatchMapping("/change-pass-employee/{newPass}/{oldPass}/{idEmployee}")
    public ResponseEntity<?> updatePasswordForEmployee (@PathVariable String newPass, @PathVariable String oldPass,
                                                        @PathVariable Long idEmployee){
        accountService.updatePasswordForEmployee(newPass,oldPass,idEmployee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

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


