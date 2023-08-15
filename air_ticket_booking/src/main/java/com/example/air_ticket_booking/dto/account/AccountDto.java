package com.example.air_ticket_booking.dto.account;

import com.example.air_ticket_booking.model.account.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AccountDto {
    private Long idAccount;
    @Size(min = 5, message = "Bạn cần nhập tối thiểu 5 ký tự")
    @Size(max = 20, message = "Bạn nhập quá 20 ký tự. Vui lòng kiểm tra lại")
//    @Pattern(regexp = "^[a-zA-ZÀ-ỹ\\s ]*$", message = "Không được nhập số và ký tự đặc biệt.")
    @NotBlank(message = "Tên không đươc để trống.")
    private String username;
    @Size(min = 5, message = "Bạn cần nhập tối thiểu 5 ký tự")
    @Size(max = 20, message = "Bạn nhập quá 20 ký tự. Vui lòng kiểm tra lại")
//    @Pattern(regexp = "^[1-9a-zA-ZÀ-ỹ\\s ]*$", message = "Không được ký tự đặc biệt.")
    @NotBlank(message = "Tên không đươc để trống.")
    private String password;
    private Role role;

    public AccountDto() {
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
