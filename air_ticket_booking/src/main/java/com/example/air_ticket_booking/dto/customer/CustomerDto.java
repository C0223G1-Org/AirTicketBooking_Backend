package com.example.air_ticket_booking.dto.customer;

import com.example.air_ticket_booking.model.account.Account;

import javax.validation.Validator;
import javax.validation.constraints.*;


public class CustomerDto {
    private Long idCustomer;
    @NotBlank(message = "Không được để trống trường này")
    @Size(max = 30, min = 3, message = "Họ và tên tối thiểu 3 ký tự và tối đa 30 ký tự ")
    @Pattern(regexp = "^[\\p{Lu}][\\p{Ll}]*([\\s][\\p{Lu}][\\p{Ll}]*)*$", message = "Bạn phải viết hoa chữ cái đầu của từng từ và có khoảng trắng giữa các từ")
    private String nameCustomer;
    private boolean genderCustomer;
    @NotBlank(message = "Không được để trống trường này")
    @Email(message = "Nhập theo định dạng email")
    @Size(min = 3, max = 50, message = "Email tối thiểu 3 ký tự và tối đa 50 ký tự")
    private String emailCustomer;
    @NotBlank(message = "Không được để trống trường này")
    @Pattern(regexp = "^(\\+84|0)[1-9][0-9]{8}$", message = "Nhập theo định dạng +84xxxxxxxxx hoặc 0xxxxxxxxx với x là ký tự số")
    @Size(min = 3, max = 20, message = "Số điện thoại tối thiểu 3 ký tự và tối đa 20 ký tự ")
    private String telCustomer;
    @NotBlank(message = "Không được để trống trường này")
    @Size(min = 3,max = 100, message = "Địa chỉ tối thiểu 3 ký tự và tối đa 100 ký tự")
    private String addressCustomer;
//    @NotBlank(message = "Không được để trống trường này")
    private String imgCustomer;
    @NotBlank(message = "Không được để trống trường này")
    private String nationalityCustomer;
    @NotBlank(message = "Không được để trống trường này")
    @Size(min = 6,max = 12, message = "CCCD/Passport tối thiểu 6 ký tự và tối đa 12 ký tự")
    @Pattern(regexp = "^([A-Z]|[0-9])+$", message = "Nhập vào chữ viết hoa và ký tự")
    private String idCardCustomer;
    @NotBlank(message = "Không được để trống trường này")
    private String dateCustomer;

    private Boolean flagCustomer;
    private Account account;

    public CustomerDto() {
    }

    public CustomerDto(Long idCustomer, String nameCustomer, Boolean genderCustomer, String emailCustomer, String telCustomer, String addressCustomer, String imgCustomer, String nationalityCustomer, String idCardCustomer, String dateCustomer, Boolean flagCustomer, Account account) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.genderCustomer = genderCustomer;
        this.emailCustomer = emailCustomer;
        this.telCustomer = telCustomer;
        this.addressCustomer = addressCustomer;
        this.imgCustomer = imgCustomer;
        this.nationalityCustomer = nationalityCustomer;
        this.idCardCustomer = idCardCustomer;
        this.dateCustomer = dateCustomer;
        this.flagCustomer = flagCustomer;
        this.account = account;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public Boolean getGenderCustomer() {
        return genderCustomer;
    }

    public void setGenderCustomer(Boolean genderCustomer) {
        this.genderCustomer = genderCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getTelCustomer() {
        return telCustomer;
    }

    public void setTelCustomer(String telCustomer) {
        this.telCustomer = telCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public String getImgCustomer() {
        return imgCustomer;
    }

    public void setImgCustomer(String imgCustomer) {
        this.imgCustomer = imgCustomer;
    }

    public String getNationalityCustomer() {
        return nationalityCustomer;
    }

    public void setNationalityCustomer(String nationalityCustomer) {
        this.nationalityCustomer = nationalityCustomer;
    }

    public String getIdCardCustomer() {
        return idCardCustomer;
    }

    public void setIdCardCustomer(String idCardCustomer) {
        this.idCardCustomer = idCardCustomer;
    }

    public String getDateCustomer() {
        return dateCustomer;
    }

    public void setDateCustomer(String dateCustomer) {
        this.dateCustomer = dateCustomer;
    }

    public Boolean getFlagCustomer() {
        return flagCustomer;
    }

    public void setFlagCustomer(Boolean flagCustomer) {
        this.flagCustomer = flagCustomer;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
