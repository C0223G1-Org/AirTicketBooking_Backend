package com.example.air_ticket_booking.dto.employee;

import com.example.air_ticket_booking.model.account.Account;

import javax.validation.constraints.*;

public class EmployeeDto {

    private Long idEmployee;
    @NotBlank(message = "Tên không đươc để trống.")
    @Size(min = 5, message = "Bạn cần nhập tối thiểu 5 ký tự")
    @Size(max = 20, message = "Bạn nhập quá 20 ký tự. Vui lòng kiểm tra lại")
    @Pattern(regexp = "^[a-zA-ZÀ-ỹ\\s ]*$", message = "Tên không được nhập số và ký tự đặc biệt.")

    private String nameEmployee;
    @Size(min = 10, message = "Bạn cần nhập tối thiểu 10 ký tự")
    @Size(max = 12, message = "Bạn nhập quá 12 ký tự. Vui lòng kiểm tra lại")
    @NotBlank(message = "Ngày sinh không đươc để trống")
//    @Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[0-1])$",
//            message = "Ngày sinh phải đúng định dạng DD/MM/YYYY.")
    private String dateEmployee;
    @Size(min = 10, max = 10, message = "Bạn cần nhập 10 ký tự")
    @NotBlank(message = "Số điện thoại không được để trống.")
    @Pattern(message = "Số điện thoại không đúng định dạng.", regexp = "^(0[0-9]{9})$")
    private String telEmployee;
    @NotBlank(message = "Không được để trống")
    private String image;

    @NotNull(message = "Chọn 1 trong 2")
    private boolean gender;
    @Size(min = 15, message = "Bạn cần nhập tối thiểu 15 ký tự")
    @Size(max = 50, message = "Bạn nhập quá 50 ký tự. Vui lòng kiểm tra lại")
    @NotBlank(message = "Email không được để trống.")
    @Email(message = "Email không đúng định dạng")
    private String emailEmployee;

    @NotNull(message = "Không được để trống")
    private Account account;

    private boolean flagEmployee;

    public EmployeeDto() {
    }


    public EmployeeDto(Long idEmployee, String nameEmployee, String dateEmployee, String telEmployee, String imageEmployee, boolean gender, String email, boolean flagEmployee) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.dateEmployee = dateEmployee;
        this.telEmployee = telEmployee;
        this.image = imageEmployee;
        this.gender = gender;
        this.emailEmployee = email;
        this.flagEmployee = flagEmployee;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getDateEmployee() {
        return dateEmployee;
    }

    public void setDateEmployee(String dateEmployee) {
        this.dateEmployee = dateEmployee;
    }

    public String getTelEmployee() {
        return telEmployee;
    }

    public void setTelEmployee(String telEmployee) {
        this.telEmployee = telEmployee;
    }


    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
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

    public boolean isGender() {
        return gender;
    }
}

