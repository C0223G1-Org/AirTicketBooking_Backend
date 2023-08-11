package com.example.air_ticket_booking.dto.account;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PassDto {
    @NotBlank (message = "Mật khẩu không được để trống")
@Size(min = 8, max = 20)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).{8,20}$", message = "Mật khẩu phải từ 8 đến 20 ký tự bao gồm chữ in hoa và số" )
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
