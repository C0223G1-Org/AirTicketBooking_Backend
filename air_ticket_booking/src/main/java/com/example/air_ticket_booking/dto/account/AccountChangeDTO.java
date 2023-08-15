package com.example.air_ticket_booking.dto.account;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class AccountChangeDTO {
    private Long id;
    @NotBlank (message = "Mật khẩu không được để trống")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).{8,20}$", message = "Mật khẩu phải từ 8 đến 20 ký tự bao gồm chữ in hoa và số" )
    private String oldPassword;

    @NotBlank (message = "Mật khẩu không được để trống")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).{8,20}$", message = "Mật khẩu phải từ 8 đến 20 ký tự bao gồm chữ in hoa và số" )
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
