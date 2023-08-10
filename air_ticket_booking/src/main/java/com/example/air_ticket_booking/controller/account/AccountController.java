package com.example.air_ticket_booking.controller.account;

import com.example.air_ticket_booking.config.JwtTokenUtil;
import com.example.air_ticket_booking.config.JwtUserDetails;
import com.example.air_ticket_booking.reponse.JwtRequest;
import com.example.air_ticket_booking.reponse.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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
//    @Autowired
//    private UsersService usersService;
//    @Autowired
//    private EmailService emailService;

    class ErrorInfo {
        private String error;
        private Long id;


    }
    @PostMapping("/authenticate")
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
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Login fail!!");
        }
    }
}
