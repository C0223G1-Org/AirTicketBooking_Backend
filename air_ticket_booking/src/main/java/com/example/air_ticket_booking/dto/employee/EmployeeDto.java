package com.example.air_ticket_booking.dto.employee;

import com.example.air_ticket_booking.model.account.Account;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeDto {

    private Long id;
    @NotBlank(message = "Tên không đươc để trống.")
    @Size(min = 5, message = "Bạn cần nhập tối thiểu 5 ký tự")
    @Size(max = 20, message = "Bạn nhập quá 20 ký tự. Vui lòng kiểm tra lại")
    private String name;
    @Size(min = 10, message = "Bạn cần nhập tối thiểu 10 ký tự")
    @Size(max = 12, message = "Bạn nhập quá 12 ký tự. Vui lòng kiểm tra lại")
    @NotBlank(message = "Ngày sinh không đươc để trống")
    @Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[0-1])$",
            message = "Ngày sinh phải đúng định dạng DD/MM/YYYY.")
    private String birthDay;
    @Size(min = 10, max = 10, message = "Bạn cần nhập 10 ký tự")
    @NotBlank(message = "Số điện thoại không được để trống.")
    @Pattern(message = "Số điện thoại không đúng định dạng.", regexp = "^(0[0-9]{9})$")
    private String telEmployee;
    private String image;

    private int gender;
    @Size(min = 10, message = "Bạn cần nhập tối thiểu 10 ký tự")
    @Size(max = 50, message = "Bạn nhập quá 20 ký tự. Vui lòng kiểm tra lại")
    @NotBlank(message = "Email không được để trống.")
    @Email(message = "Email không đúng định dạng")
    private String email;
    private Account account;

    private boolean flagEmployee;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String name, String birthDay, String telEmployee, String image, int gender, String email, boolean flagEmployee) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.telEmployee = telEmployee;
        this.image = image;
        this.gender = gender;
        this.email = email;
        this.flagEmployee = flagEmployee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getTelEmployee() {
        return telEmployee;
    }

    public void setTelEmployee(String telEmployee) {
        this.telEmployee = telEmployee;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isFlagEmployee() {
        return flagEmployee;
    }

    public void setFlagEmployee(boolean flagEmployee) {
        this.flagEmployee = flagEmployee;
    }
}

