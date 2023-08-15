package com.example.air_ticket_booking.dto.account;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class JwtRequestDto {
    @NotBlank(message = "Không được để trống trường này")
    @Pattern(regexp = "^\\w+@\\w+(.\\w+)$", message = "Nhập theo định dạng: xxx@xxx.xxx với x không phải là ký tự đặc biệt ")
    private String username;
    @NotBlank(message = "Không được để trống trường này")
    @Size(min = 8, max = 20, message = "Mật khẩu phải từ 8 ký tự và ít hơn 20 ký tự")
    private String password;

    public JwtRequestDto() {}

    public JwtRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
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
}
